(ns rainfall
  (:require [clojure.edn :as edn]))

(defn returns [val & _] val)

(defn average [coll]
  (/ (reduce + coll) (count coll)))

(defn normalize-rainfall [rainfall]
  (->> rainfall
       (take-while (partial not= -999))
       (filter (comp not neg?))))

(defn rainfall-average [rainfall]
  (let [normalized (normalize-rainfall rainfall)]
    (if (seq normalized)
      (-> normalized average float)
      :no-result)))

(defn -main [& args]
  (returns nil
    (let [rainfall-lists    (map edn/read-string args)
          rainfall-averages (map rainfall-average rainfall-lists)]
      (doseq (map #(println (str %1 " -> " %2))
                  rainfall-lists
                  rainfall-averages)))))

