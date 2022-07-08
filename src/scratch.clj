(ns scratch
  (:require [clojure.java.io :as io]
            [xtdb.api :as xt]))

(defn start-xtdb! []
  (letfn [(kv-store [dir]
            {:kv-store {:xtdb/module 'xtdb.rocksdb/->kv-store
                        :db-dir (io/file dir)
                        :sync? true}})]
    (xt/start-node
     {:xtdb/tx-log (kv-store "data/tx-log")
      :xtdb/document-store (kv-store "data/doc-store")
      :xtdb/index-store (kv-store "data/index-store")})))

(def xtdb-node (start-xtdb!))

(def data (read-string (slurp "resources/entities.edn")))

(do
  (xt/submit-tx xtdb-node (doall (map #(vector ::xt/put %) data)))
  ;; (xt/sync xtdb-node)
  (.close xtdb-node))
