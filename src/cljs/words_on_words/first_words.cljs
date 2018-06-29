(ns words-on-words.first-words)

(defonce sample-sentence [:hello :darkness])

(def synonyms {:hello [:welcome :greetings] :darkness [:void :vacancy]})

(defn thesaurize [a-word]
  (if (= (synonyms a-word) a-word)
    (rand-nth (synonyms a-word))
    a-word))