(ns example-mod.tabs
  (:use clj-forge.creative-tabs)
  (:require [clj-forge.creative-tabs]))

(def example-tab
  (create-tab
    :name            "example-tab"
    :mod-id          "example-mod"
    :icon-item-name  "lambda"))