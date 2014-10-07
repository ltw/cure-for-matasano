(ns matasano.set-1.challenge-3-test
  (:require [clojure.test :refer :all]
            [matasano.set-1.challenge-3 :as m]))

(deftest decode
  (testing "decodes a hex string into a UTF-8 string"
    (let [p (m/decode "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736")]
      (is (= (:result p) "Cooking MC's like a pound of bacon"))
      (is (= (:char p)   \X)))))
