(ns matasano.core
  (:require [clojure.tools.cli :as cli]))

(def func-name "matasano.set-%d.challenge-%d")

(def cli-options
  [["-s" "--set SET" "Set number"
    :default 1
    :parse-fn #(Integer/parseInt %)]
   ["-c" "--challenge CHALLENGE" "Challenge number"
    :default 1
    :parse-fn #(Integer/parseInt %)]])

(defn func-for
  "Resolve the function for a set and challenge combination."
  [set challenge]
  (let [challenge-str (format func-name set challenge)]
    (try
      (do
        (-> challenge-str symbol require)
        (-> (str challenge-str "/run") symbol resolve))
      (catch java.io.FileNotFoundException e
        (println "ERROR: Challenge does not exist.")))))

(defn print-challenge [set challenge result]
  (println
   (format "Set %d, Challenge %d - Result: %s" set challenge result)))

(defn -main
  [& args]
  (let [{:keys [set challenge]} (:options (cli/parse-opts args cli-options))
        challenge-fn            (func-for set challenge)]
    (and challenge-fn
         (print-challenge set challenge (challenge-fn)))))
