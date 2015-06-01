(ns example-mod.crafting
  (:use clj-forge.crafting
        clj-forge.items)
  (:require [example-mod.items :as ex-items]
            [example-mod.blocks :as ex-blocks])
  (:import (net.minecraft.init Items)))

(defn init []
  (let [material-map {\I Items/iron_ingot
                      \E ex-items/lambda
                      \T ex-blocks/lambda-block}]
    (register-recipe example-mod.items/lambda
                     material-map
                     ["I  "
                      " I "
                      "I I"] )
    (register-recipe ex-blocks/lambda-block
                     material-map
                     ["EEE"
                      "EEE"
                      "EEE"])
    (register-recipe (item-stack ex-items/lambda 9)
                     material-map
                     "T"))
  (register-smelting ex-items/lambda
                     ex-blocks/lambda-block
                     0.2))
