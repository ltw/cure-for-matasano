(ns matasano.set-1.challenge-4-test
  (:require [clojure.test :refer :all]
            [matasano.set-1.challenge-4 :as m]))

(def search-strings
  '("0d17272f53063954163d050a541b1f1144305ae37d4932431b1f33140b1b"
    "29011616565d2a372a605bee39eced31183fe068185c3b445b391fe53232"
    "7b5a4215415d544115415d5015455447414c155c46155f4058455c5b523f"
    "2d3c230a1e5a300f6c3e26ed0d1709434950fd6f1e121335054129e4e4ec"))

(deftest find-encrypted-string
  (testing "finds an encrypted string in an input file"
    (let [p (m/find-encrypted-string search-strings)]
      (is (= (:result p) "Now that the party is jumping\n"))
      (is (= (:char p)   \5)))))
