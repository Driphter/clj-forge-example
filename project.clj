(defproject example-mod "1.1.0-SNAPSHOT"
            :description "FIXME: write description"
            :dependencies [[org.clojure/clojure "1.6.0"]
                           [driphter/clj-forge "0.1.0-SNAPSHOT"]
                           [net.minecraftforge/forgeSrc "1.7.10-10.13.3.1403-1.7.10"]]
            :plugins [[lein-cljfmt "0.1.10"]
                      [lein-kibit "0.1.2"]]
            :aot :all
            :source-path "src/main/clojure"
            :repositories [["forge" "http://files.minecraftforge.net/maven"]])
