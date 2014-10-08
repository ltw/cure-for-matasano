(ns ^{:author "Lucas Willett"
      :desc   ""}
  matasano.set-1.challenge-4
  (:require [matasano.converters :as c]
            [clojure.java.io :as io]
            [clojure.string :as s]
            [matasano.set-1.challenge-3 :as s1c3]))

(defn find-encrypted-string
  [input-seq]
  (s1c3/get-result
   (reduce
    (fn [coll input-str]
      (concat (remove nil? (s1c3/decode input-str)) coll))
    '()
    input-seq)))

(defn load-input
  "Load a sequence of hex-encoded strings from a file"
  [filename]
  (s/split (slurp (io/resource filename)) #"\n"))

(defn run []
  (find-encrypted-string (load-input "4.txt")))
