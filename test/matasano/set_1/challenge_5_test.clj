(ns matasano.set-1.challenge-5-test
  (:require [clojure.test :refer :all]
            [matasano.set-1.challenge-5 :as m]))

(def expected-result
  "0b3637272a2b2e63622c2e69692a23693a2a3c6324202d623d63343c2a26226324272765272a282b2f20430a652e2c652a3124333a653e2b2027630c692b20283165286326302e27282f")

(def test-str
  "Burning 'em, if you ain't quick and nimble
I go crazy when I hear a cymbal")

(deftest encrypt-str
  (testing "finds an encrypted string in an input file"
    (let [p (m/encrypt-str test-str :with "ICE")]
      (is (= p expected-result)))))
