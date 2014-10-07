(ns matasano.set-1.challenge-1-test
  (:require [clojure.test :refer :all]
            [matasano.set-1.challenge-1 :as m]))

(deftest hex->base64-test
  (testing "converts hex string to base64"
    (is (= (m/hex->base64 "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d")
           "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t"))))
