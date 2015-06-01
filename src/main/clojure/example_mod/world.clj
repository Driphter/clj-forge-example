(ns example-mod.world
  (:use [clj-forge.world-gen :only [gen-minable]])
  (:require [example-mod.blocks :as ex-blocks])
  (:import (java.util Random)
           (net.minecraft.world World)))

(defn- -add-ore-spawn
  [block world ^Random random x z
   & {:keys [vein-count min-size max-size min-y max-y]
      :or {vein-count 1
           min-size   0
           max-size   1
           min-y      0
           max-y      48}}]
  (dotimes [_ vein-count]
    (let [x (+ x (.nextInt random 16))
          y (+ min-y (.nextInt random (- max-y min-y)))
          z (+ z (.nextInt random 16))]
      (gen-minable block min-size max-size world random x y z))))

(defn- -gen-overworld
  [random x z world]
  (-add-ore-spawn ex-blocks/lambda-block
                  world random x z
                  :min-size   2
                  :max-size   5
                  :vein-count 9))

(defn- -gen-nether
  [random x z world])

(defn- -gen-end
  [random x z world])

(defn init []
  (clj-forge.world-gen/register-world-gen
    (fn [random x z ^World world]
      (let [x (* x 16)
            z (* z 16)]
        (case (-> world .provider .dimensionId)
          0  (-gen-overworld random x z world)
          -1 (-gen-nether random x z world)
          1  (-gen-end random x z world))))))
