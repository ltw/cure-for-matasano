(ns ^{:author "Lucas Willett"
      :desc   ""}
  matasano.set-1.challenge-5
  (:require [matasano.converters :as c]))

(def ^:private test-str
  "Burning 'em, if you ain't quick and nimble
I go crazy when I hear a cymbal")

(defn encrypt-str
  "Encrypts a string with a repeating-key XOR"
  [input-str & {:keys [with :as xor-key]}]
  (let [input-bytes (.getBytes input-str)
        xor-bytes   (take (count input-bytes) (cycle (.getBytes "ICE")))]
    (c/bytes->hex (map bit-xor input-bytes xor-bytes))))

(defn run []
  (encrypt-str test-str :with "ICE"))
