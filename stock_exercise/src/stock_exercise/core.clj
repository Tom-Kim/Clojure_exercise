(ns stock-exercise.core
  (:use     clj-quandl.core)
  (:require [clj-http.client :as client]
            [clj-time.core :as time]
            [clj-time.format :as f]
            [clj-quandl.core :refer :all]
            [cheshire.core :refer :all]
            
            )
  (:gen-class))

"Quandl token to do API calls"
(def auth-token "-xvzyytDom9qJHjjsZMv")

(def quandl-api-url "https://www.quandl.com/api/v1/datasets/WIKI/")

(def date-today #(clojure.string/join "-" [(time/year (time/today)) (time/month (time/today)) (time/day (time/today))]))

(def year-ago-today #(clojure.string/join "-" [(- (time/year (time/today)) 1) (time/month (time/today)) (time/day (time/today))]))

(def test-url #(str quandl-api-url "AAPL.json?auth_token=" auth-token
                    "&trim_start=" 'year-ago-today "&trim_end=" 'date-today
                   "&column=4&exclude_headers=true"))

"Flags"
(defn daily-winners
  "Prints stocks that had the highest % gain or lowest % loss for each day"
  []
  "get stock data for past year and then compare closing prices for each day for
given stock symbols

loop -> compare -> print"
  (let [today (clojure.string/join "-" [(time/year (time/today)) (time/month (time/today)) (time/day (time/today))])
        last-year (clojure.string/join "-" [(- (time/year (time/today)) 1) (time/month (time/today)) (time/day (time/today))])
        test (quandl "WIKI/AAPL" :auth-token "-xvzyytDom9qJHjjsZMv&column=4" :start-date last-year :end-date today :map-data true)
        days (take 10 test)
        ]
    (reverse (sort-by #(Double/parseDouble (:Close %)) days)))
  
)

(defn weekly-winners
  "Prints stocks that had the highest % gain or lowest % loss for each week
Fri-Fri"
  []
  "get stock data for the past year and then average change in closing price for each week.  Compare deltas and print winners

loop -> daily-winners -> average -> compare delta -> print"
  (let [today (clojure.string/join "-" [(time/year (time/today)) (time/month (time/today)) (time/day (time/today))])
        last-year (clojure.string/join "-" [(- (time/year (time/today)) 1) (time/month (time/today)) (time/day (time/today))])
        week-test (quandl "WIKI/AAPL" :auth-token "-xvzyytDom9qJHjjsZMv&column=4" :start-date last-year :end-date today :map-data true :frequency "weekly")]
    (take 10 (sort-by :Close week-test)))
  )

(defn tops
  "Prints top 10 closing prices and dates for each stock"
  []
  "get stick data for the past year and then compare all closing prices for
highest ones.  Print with date

loop -> compare closing prices -> print top 10"
  (let [today (clojure.string/join "-" [(time/year (time/today)) (time/month (time/today)) (time/day (time/today))])
        last-year (clojure.string/join "-" [(- (time/year (time/today)) 1) (time/month (time/today)) (time/day (time/today))])
        apple (quandl "WIKI/AAPL" :auth-token "-xvzyytDom9qJHjjsZMv&column=4" :start-date last-year :end-date today :map-data true)]
    (take 10 (reverse (sort-by #(Double/parseDouble (:Close %)) apple))))
  )

(defn bottoms
  "Prints bottom 10 closing prices and dates for each stock"
  []
  "get stock data for the past year and then compare all closing prices for
lowest ones.  Print with date

loop -> compare closing prices -> print bottom 10"
  (let [today (clojure.string/join "-" [(time/year (time/today)) (time/month (time/today)) (time/day (time/today))])
        last-year (clojure.string/join "-" [(- (time/year (time/today)) 1) (time/month (time/today)) (time/day (time/today))])
        apple (quandl "WIKI/AAPL" :auth-token "-xvzyytDom9qJHjjsZMv&column=4" :start-date last-year :end-date today :map-data true)]
    (take 10 (sort-by #(Double/parseDouble (:Close %)) apple)))
  )

(defn price-graph
  "Displays a line chart plotting daily closing prices for all stocks - using incanter"
  []
  )

(defn weekly-graph
  "Displays candlestick chart plotting weekly price activity for all stocks - using incanter"
  []
  )

(defn money-game
  "Simulates optimal investing for $100k based on closing day prices of stocks"
  []
  )

"Given a set of stock symbols and flags as input, program should download the
daily closing data for each of the stocks for the last year and implement
flags given"
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
