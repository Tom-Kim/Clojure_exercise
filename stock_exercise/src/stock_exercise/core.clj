(ns stock-exercise.core
  (:gen-class))

"Flags"
(defn daily-winners
  "Prints stocks that had the highest % gain or lowest % loss for each day"
  [stocks & args]
  )

(defn weekly-winners
  "Prints stocks that had the highest % gain or lowest % loss for each week
Fri-Fri"
  [stocks & args]
  )

(defn tops
  "Prints top 10 closing prices and dates for each stock"
  [stocks & args]
  )

(defn bottoms
  "Prints bottom 10 closing prices and dates for each stock"
  [stocks & args]
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
