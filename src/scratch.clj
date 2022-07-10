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

(defn data [n]
  (->> (range n)
       (map (fn [i] {:xt/id i :some/data (str (random-uuid))}))))

(comment
  (do
    (xt/submit-tx xtdb-node (doall (map #(vector ::xt/put %) (data 10000))))
    ;; (xt/sync xtdb-node)
    (.close xtdb-node)))
