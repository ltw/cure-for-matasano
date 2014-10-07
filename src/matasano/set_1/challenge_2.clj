(ns matasano.set-1.challenge-2
  (:require [matasano.converters :as c]
            [clojure.string :as s]))

(defn xor->hex-str [byte1 byte2]
  (format "%x" (bit-xor byte1 byte2)))

(defn fixed-xor
  "XORs two hexadecimal strings"
  [hex1 hex2]
  (s/join
   (map #(xor->hex-str %1 %2)
        (c/hex->bytes hex1)
        (c/hex->bytes hex2))))

(defn run
  "Challenge 2: Fixed XOR"
  []
  (fixed-xor "1c0111001f010100061a024b53535009181c"
             "686974207468652062756c6c277320657965"))
