(ns matasano.set-1.challenge-1
  (:require [matasano.converters :as c]))

(defn hex->base64
  "Converts a hexadecimal string into a base64-encoded string"
  [hex]
  (-> hex c/hex->bytes c/bytes->base64))

(defn run
  "Challenge 1: Convert hex to base64."
  []
  (hex->base64 "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d"))
