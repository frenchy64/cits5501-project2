(ns org.ambrosebs.clj-util
  (:require [clojure.string :as str]
            [clojure.set :as set]
            [clojure.core.typed :refer [ann check-ns fn>]]
            [clojure.tools.trace :as trace])
  (:import (org.openqa.selenium WebElement)
           (clojure.lang Seqable IPersistentSet)))

(ann ^:nocheck clojure.string/trim [String -> String])
(ann ^:nocheck clojure.string/split-lines [String -> (Seqable String)])

(ann actual-messages [(Seqable WebElement) -> (Seqable String)])
(defn actual-messages 
  "The actual error messages contained in the WebElements, trimmed
  and split"
  [webelements]
  #_{:pre [(every? #(instance? WebElement %) webelements)]
   :post [(every? string? %)]}
  (mapcat (fn> [^WebElement w :- WebElement]
            (->> (str (.getText w))
                 str/split-lines
                 (map str/trim)))
          webelements))

(ann ^:nocheck clojure.set/difference 
     (All [x]
       [(IPersistentSet x) (IPersistentSet Any) * -> (IPersistentSet x)]))

(ann assert-all-errors-appear [(Seqable String) (Seqable WebElement) -> nil])
(defn assert-all-errors-appear
  "Given a set of expected messages, ensure that the web
  elements provided contain at least those messages"
  [expected-msgs actual-webelements]
  #_{:pre [(every? string? expected-msgs)
         (every? #(instance? WebElement %) actual-webelements)]}
  (let [actual-msgs (actual-messages actual-webelements)
        missing-msgs (set/difference (set expected-msgs)
                                     (set actual-msgs))]
    (assert (empty? missing-msgs)
            (str "These messages did not appear: "
                 missing-msgs))))

(ann ^:nocheck clojure.set/intersection
     (All [x]
       [(IPersistentSet x) (IPersistentSet x) * -> (IPersistentSet x)]))

(ann assert-forbidden-errors [(Seqable String) (Seqable WebElement) -> nil])
(defn assert-forbidden-errors
  "Given a set of expected messages, ensure that the web
  elements provided do not occur on the page."
  [forbidden-msgs actual-webelements]
  #_{:pre [(every? string? forbidden-msgs)
         (every? #(instance? WebElement %) actual-webelements)]}
  (let [actual-msgs (actual-messages actual-webelements)
        found-forbidden (set/intersection (set forbidden-msgs)
                                          (set actual-msgs))]
    (assert (empty? found-forbidden)
            (str "These forbidden messages appeared: "
                 found-forbidden))))

#_(trace/trace-ns *ns*)
