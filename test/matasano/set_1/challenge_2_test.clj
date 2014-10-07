(ns matasano.set-1.challenge-2-test
  (:require [clojure.test :refer :all]
            [matasano.set-1.challenge-2 :as m]))

(deftest fixed-xor-test
  (testing "XORs two hexadecimal strings"
    (is (= (m/fixed-xor "1c0111001f010100061a024b53535009181c"
                        "686974207468652062756c6c277320657965")
           "746865206b696420646f6e277420706c6179"))))
