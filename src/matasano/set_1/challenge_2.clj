(ns matasano.set-1.challenge-2
  (:require [matasano.converters :as c]
            [clojure.string :as s]))

(defn fixed-xor
  "XORs two hexadecimal strings"
  [hex1 hex2]
  (-> (map bit-xor
           (c/hex->bytes hex1)
           (c/hex->bytes hex2))
      c/bytes->hex))

(defn run
  "Challenge 2: Fixed XOR"
  []
  (fixed-xor "1c0111001f010100061a024b53535009181c"
             "686974207468652062756c6c277320657965"))
