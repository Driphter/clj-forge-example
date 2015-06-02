(ns example-mod.items
  (:use [clojure.string :only [lower-case]]
        clj-forge.items
        example-mod.version)
  (:require [example-mod.tabs :as ex-tabs]))

(def lambda
  (create-item
    :name          "lambda"
    :mod-id        mod-id
    :creative-tab  ex-tabs/example-tab))

(defn init []
  (register-item lambda))