(ns stock-exercise.core
  (:require [clj-http.client :as client]
            [clj-time.core :as time]
            [clj-time.format :as f]
            [clj-quandl.core :as quandl]
            [cheshire.core :refer :all]
            )
  (:gen-class))

(use 'clj-quandl.core)
"Quandl token to do API calls"
(def auth-token "-xvzyytDom9qJHjjsZMv")

(def built-in-formatter (f/formatters :date))
(def date-today #(clojure.string/join "-" [(time/year (time/today)) (time/month (time/today)) (time/day (time/today))]))

(def year-ago-today #(clojure.string/join "-" [(- (time/year (time/today)) 1) (time/month (time/today)) (time/day (time/today))]))
"Flags"
(defn daily-winners
  "Prints stocks that had the highest % gain or lowest % loss for each day"
  []
  "get stock data for past year and then compare closing prices for each day for
given stock symbols

loop -> compare -> print"
  (let [s1 (quandl "WIKI/AAPL" :auth-token auth-token
                   :start-date "2013-12-07" :end-date "2014-12-07"
                   :transform "rdiff"
                   :map-data true :sort-order "asc")
        s2 (client/get "https://www.quandl.com/api/v1/datasets/WIKI/AAPL.json?trim_start=2013-12-07&trim_end=2014-12-07&column=4&auth_token=-xvzyytDom9qJHjjsZMv")]
    (generate-string (take 10 s2)))
  
  )

(defn weekly-winners
  "Prints stocks that had the highest % gain or lowest % loss for each week
Fri-Fri"
  [stocks]
  "get stock data for the past year and then average change in closing price for each week.  Compare deltas and print winners

loop -> daily-winners -> average -> compare delta -> print"
  )

(defn tops
  "Prints top 10 closing prices and dates for each stock"
  [stocks]
  "get stick data for the past year and then compare all closing prices for
highest ones.  Print with date

loop -> compare closing prices -> print top 10"
  )

(defn bottoms
  "Prints bottom 10 closing prices and dates for each stock"
  [stocks]
  "get stock data for the past year and then compare all closing prices for
lowest ones.  Print with date

loop -> compare closing prices -> print bottom 10"
  )

(defn price-graph
  "Displays a line chart plotting daily closing prices for all stocks"
  [stocks]
  )

(defn weekly-graph
  "Displays candlestick chart plotting weekly price activity for all stocks"
  [stocks]
  )

(defn money-game
  "Simulates optimal investing for $100k based on closing day prices of stocks"
  [stocks]
  )

"Given a set of stock symbols and flags as input, program should download the
daily closing data for each of the stocks for the last year and implement
flags given"
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
