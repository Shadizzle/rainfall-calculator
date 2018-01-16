(ns rainfall
  (:require [clojure.edn :as edn]))

(defn normalize-rainfall [rainfall]
  (->> rainfall
       (take-while #(not= % -999))
       (filter #(not (neg? %)))))

(defn rainfall-average [rainfall]
  (let [normalized (normalize-rainfall rainfall)]
    (if (seq normalized)
      (float (/ (reduce + normalized) (count normalized)))
      :no-result)))

(defn -main [& args]
  (let [rainfall-lists    (map edn/read-string args)
        rainfall-averages (map rainfall-average rainfall-lists)]
    (doall (map #(println (str %1 " -> " %2))
                rainfall-lists
                rainfall-averages))))
