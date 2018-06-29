(ns words-on-words.read-eval-write-loop
  (:require
    [reagent.core :as r])
  (:use
    [words-on-words.first-words :only (sample-sentence)]
    [clojure.string :only (join)]
    [cljs.js :only (eval)]
    [cljs.reader :only (read-string)]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Reader

(defn utterance-input [value]
  [:input {:type "text"
           :value @value
           :on-change #(reset! value (-> % .-target .-value))}])

(defn utterance-reader [uttered]
    (fn []
      [:div#utterance-parser
       [:p "Utter: " [utterance-input uttered]]
       [:p "You are trying to say " @uttered]]))

(defn eval-and-say [code-said]
  [:p (read-string code-said)])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;,
;; Page

(defn page []
  (let [uttered (r/atom "No")]
    [:div#all-of-it
    [:div#text-frame
      [:p (join " " (map name sample-sentence))]
      [eval-and-say @uttered]]
    [utterance-reader uttered]]))