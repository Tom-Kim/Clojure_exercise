(ns stock-exercise.core
  (:require [clj-http.client :as stock])
  (:gen-class))

(use 'clj-quandl.core)

"Quandl token to do API calls"
(def auth-token "-xvzyytDom9qJHjjsZMv")

(def quandl-api "http://www.quandl.com/api/v1/datasets/WIKI")

"Flags"
(defn daily-winners
  "Prints stocks that had the highest % gain or lowest % loss for each day"
  [stocks & args]
  "get stock data for past year and then compare closing prices for each day for
given stock symbols

loop -> compare -> print"
  
  )

(defn weekly-winners
  "Prints stocks that had the highest % gain or lowest % loss for each week
Fri-Fri"
  [stocks & args]
  "get stock data for the past year and then average change in closing price for each week.  Compare deltas and print winners

loop -> daily-winners -> average -> compare delta -> print"
  )

(defn tops
  "Prints top 10 closing prices and dates for each stock"
  [stocks & args]
  "get stick data for the past year and then compare all closing prices for
highest ones.  Print with date

loop -> compare closing prices -> print top 10"
  )

(defn bottoms
  "Prints bottom 10 closing prices and dates for each stock"
  [stocks & args]
  "get stock data for the past year and then compare all closing prices for
lowest ones.  Print with date

loop -> compare closing prices -> print bottom 10"
  )

(defn price-graph
  "Displays a line chart plotting daily closing prices for all stocks"
  [stocks & args]
  )

(defn weekly-graph
  "Displays candlestick chart plotting weekly price activity for all stocks"
  [stocks & args]
  )

(defn money-game
  "Simulates optimal investing for $100k based on closing day prices of stocks"
  [stocks & args]
  )

"Given a set of stock symbols and flags as input, program should download the
daily closing data for each of the stocks for the last year and implement
flags given"
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
