(ns example-mod.blocks
  (:use [clojure.string :only [lower-case]]
        [clj-forge.blocks])
  (:require [example-mod.tabs :as ex-tabs])
  (:import (net.minecraft.block.material Material)
           (net.minecraft.block Block)))

(def lambda-block
  (create-block :name           "lambda-block"
                :mod-id         "example-mod"
                :material       Material/iron
                :creative-tab   ex-tabs/example-tab
                :step-sound     Block/soundTypeStone
                :hardness       2.5
                :resistance     10
                :harvest-tool   "pickaxe"
                :harvest-level  3))

(defn init []
  (register-block lambda-block))

