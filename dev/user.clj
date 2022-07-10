(ns user
  (:require [clojure.java.io :as io]
            #_[clojure.tools.namespace.repl :as repl]
            #_[lambdaisland.classpath.watch-deps :as watch-deps]))

;; (defn watch-deps!
;;   []
;;   (watch-deps/start! {:aliases [:dev :test]}))

;; (defn go []
;;   (watch-deps!))

;; (comment
;;   (repl/set-refresh-dirs (io/file "src") (io/file "dev"))
;;   (repl/refresh)
;;   (repl/clear)

;;   (watch-deps!)

;;   )
