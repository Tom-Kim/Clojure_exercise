(defproject stock_exercise "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
				[clj-time "0.8.0"]
				[clj-http "1.0.1"]
				[clj-quandl "0.1.0-SNAPSHOT"]]
  :main ^:skip-aot stock-exercise.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
