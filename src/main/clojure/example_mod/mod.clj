(ns example-mod.mod
  (:import (cpw.mods.fml.common FMLLog)
           (org.apache.logging.log4j Level))
  (:require example-mod.items
            example-mod.blocks
            example-mod.world
            example-mod.crafting))

(gen-class :name ^{cpw.mods.fml.common.Mod {:modid    "example-mod"
                                            :name     "example-mod"
                                            :version  "0.1.0"}}
                 driphter.ExampleMod
           :prefix -mod-
           :methods [[^{cpw.mods.fml.common.Mod$EventHandler {}}
                     preInit [cpw.mods.fml.common.event.FMLPreInitializationEvent] void]
                     [^{cpw.mods.fml.common.Mod$EventHandler {}}
                     init [cpw.mods.fml.common.event.FMLInitializationEvent] void]
                     [^{cpw.mods.fml.common.Mod$EventHandler {}}
                     postInit [cpw.mods.fml.common.event.FMLPostInitializationEvent] void]])

(defn log-info
  [^String message & data]
  (FMLLog/log "example-mod" Level/INFO message (to-array data)))

(defn -mod-preInit
  [_ event]
  (log-info "Pre-Init!")
  (example-mod.items/init)
  (example-mod.blocks/init)
  (example-mod.crafting/init)
  (example-mod.world/init))

(defn -mod-init
  [_ event]
  (log-info "Init!"))

(defn -mod-postInit
  [_ event]
  (log-info "Post-Init!"))