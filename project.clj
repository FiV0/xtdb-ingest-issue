(defproject xtdb-ingest-issue "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure    "1.11.0"]
                 [com.xtdb/xtdb-core     "1.21.0"]
                 [com.xtdb/xtdb-rocksdb  "1.21.0"]]
  :main ^:skip-aot scratch
  :target-path "target/%s"
  :resource-paths ["resources"]
  :profiles
  {:uberjar
   {:aot :all
    :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}

   :dev
   {:dependencies [[ch.qos.logback/logback-classic "1.2.3"]]}})
