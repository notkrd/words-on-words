(ns words-on-words.core
  (:require
   [reagent.core :as r]
   )
  (:use
    [clojure.string :only (join)]
    [words-on-words.first-words :only (sample-sentence)]
    [words-on-words.read-eval-write-loop :only (page)]))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Vars

(defonce app-state
         (r/atom {}))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Initialize App

(defn dev-setup []
  (when ^boolean js/goog.DEBUG
    (enable-console-print!)
    (println "dev mode")
    ))

(defn reload []
  (r/render [page]
            (.getElementById js/document "app")))

(defn ^:export main []
  (dev-setup)
  (reload))
