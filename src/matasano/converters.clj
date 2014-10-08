(ns matasano.converters
  (:require [clojure.data.codec.base64 :as b64]
            [clojure.string :as s]))

(defn hex->bytes
  "Converts hexadecimal string to byte array"
  [hex]
  (.toByteArray (BigInteger. hex 16)))

(defn bytes->str
  "Converts a byte sequence into a UTF-8 string"
  [bytes]
  (s/join (map char bytes)))

(defn hex->str
  "Converts a hexadecimal string to a UTF-8 string"
  [hex]
  (-> hex hex->bytes bytes->str))

(defn bytes->base64
  "Converts a byte array into a base64-encoded string."
  [bytes]
  (-> bytes b64/encode String.))

(defn bytes->hex
  "Converts a byte array into a hexadecimal string"
  [bytes]
  (s/join (map (partial format "%02x") bytes)))

(defn str->base64
  "Converts a UTF-8 string into a base64-encoded string"
  [str]
  (-> str .getBytes bytes->base64))
