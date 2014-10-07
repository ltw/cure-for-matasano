(ns matasano.converters-test
  (:require [clojure.test :refer :all]
            [matasano.converters :as c]))

(deftest hex->str-test
  (testing "converts hex string to string"
    (is (= (c/hex->str "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d")
           "I'm killing your brain like a poisonous mushroom"))))

(deftest str->base64-test
  (testing "converts string to base64"
    (is (= (c/str->base64 "I'm killing your brain like a poisonous mushroom")
           "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t"))))
