(ns org.ambrosebs.clj-util
  (:require [clojure.string :as str]
            [clojure.set :as set])
  (:import (org.openqa.selenium WebElement)))

(defn assert-all-errors-appear
  "Given a set of expected messages, ensure that the web
  elements provided contain at least those messages"
  [expected-msgs actual-webelements]
  {:pre [(every? string? expected-msgs)
         (every? #(instance? WebElement %) actual-webelements)]}
  (let [actual-msgs (mapcat #(->> (.getText ^WebElement %)
                                  str/split-lines
                                  (map str/trim))
                            actual-webelements)]
    (assert (set/difference (set expected-msgs)
                            (set actual-msgs))
            (str "These messages did not appear: "
                 (set/difference (set expected-msgs)
                                 (set actual-msgs))))))
