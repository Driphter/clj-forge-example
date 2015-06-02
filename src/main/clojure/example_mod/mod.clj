(ns example-mod.mod
  (:import (cpw.mods.fml.common FMLLog)
           (org.apache.logging.log4j Level))
  (:use example-mod.version
        clj-forge.mod)
  (:require example-mod.items
            example-mod.blocks
            example-mod.world
            example-mod.crafting))

(defn log-info
  [^String message & data]
  (FMLLog/log "example-mod" Level/INFO message (to-array data)))

(defn pre-init
  [_]
  (log-info "Pre-Init!")
  (example-mod.items/init)
  (example-mod.blocks/init)
  (example-mod.crafting/init)
  (example-mod.world/init))

(defn init
  [_]
  (log-info "Init!"))

(defn post-init
  [_]
  (log-info "Post-Init!"))

(defmod "driphter.ExampleMod"
        :mod-id    mod-id
        :mod-name  mod-name
        :version   mod-ver
        :pre-init  pre-init
        :init      init
        :post-init post-init)
