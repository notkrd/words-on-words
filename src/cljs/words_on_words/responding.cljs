(ns words-on-words.responding
  (:use
    [words-on-words.first-words :only (thesaurize)]
    [clojure.string :only (split, join)]))

(defn on-words [text a-fn]
   (split text #"\s+"))

(defn respond [utterance text]
  (cond
    (= utterance "thesaurize") ()
    :else text))