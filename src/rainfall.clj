(ns rainfall
  (:require [clojure.edn :as edn]))

(defn average [coll]
  (/ (reduce + coll) (count coll)))

(defn normalize-rainfall [rainfall]
  (->> rainfall
       (take-while (partial not= -999))
       (filter (complement neg?))))

(defn rainfall-average [rainfall]
  (let [normalized (normalize-rainfall rainfall)]
    (if (seq normalized)
      (-> normalized average float)
      :no-result)))

(defn -main [& args]
  (let [rainfall-lists    (map edn/read-string args)
        rainfall-averages (map rainfall-average rainfall-lists)]
    (doseq [[list average] (map list rainfall-lists rainfall-averages)]
      (println (str list " -> " average)))))

