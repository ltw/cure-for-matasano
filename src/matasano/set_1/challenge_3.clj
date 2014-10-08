(ns ^{:author "Lucas Willett"
      :desc   "Using the approximate frequency of commonly used letters
              in the English language, this decodes a hexadecimal string
              against each letter of the alphabet and then scores the most
              likely result."}
  matasano.set-1.challenge-3
  (:require [matasano.converters :as c]
            [clojure.string :as s]))

(defn char-range-in-bytes
  "Generate a character range between characters"
  [start end]
  (range (int start) (int end)))

(def letter-score-bytes
  "Returns a frequency-weighted byte array of the most common
  characters used in the English language"
  (-> "ETAOIN SHRDLU" s/lower-case .getBytes reverse))

(def xor-character-bytes
  "Returns a byte array of all alphabetic characters"
  (range 0 255))

(defn get-letter-score-for-decryption
  ;; TODO - fix the docstring
  "Scores a byte sequence based on the frequency of these characters
  used in the English language"
  [result-bytes]
  (reduce
   (fn [sum letter-byte]
     (+ sum (inc (.indexOf letter-score-bytes letter-byte))))
   result-bytes))

(defn xor-on-bytes
  "XORs an input sequence against a single byte, and returns a decoding score
  for the resulting XOR'd sequence"
  [input-seq score-fn xor-byte]
  (let [result (map (partial bit-xor xor-byte) input-seq)]
    {:score  (score-fn result)
     :result (s/join (map char result))
     :char   (char xor-byte)}))

(defn get-result
  "Figures out the optimal result and returns it"
  [results]
  (->> results (sort-by :score) reverse first))

(defn decode
  "Attempt to decode a hex string against a single byte key into a UTF-8 string"
  [input]
  (let [input-bytes (c/hex->bytes input) ; only ever work in bytes
        score-fn    get-letter-score-for-decryption]
    (->> xor-character-bytes
         (map (partial xor-on-bytes input-bytes score-fn))
         get-result)))

(defn run
  "Challenge 3: Single-byte XOR cipher"
  []
  (:result (decode "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736")))
