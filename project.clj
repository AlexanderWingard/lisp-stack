(defproject lisp-stack "0.0.1"
  :dependencies
  [[com.cemerick/piggieback "0.2.2"]
   [figwheel-sidecar "0.5.13"]
   [org.clojure/clojure "1.8.0"]
   [org.clojure/clojurescript "1.9.908"]
   [org.clojure/tools.nrepl "0.2.10"]
   [reagent "0.7.0"]
   [reagent-forms "0.5.29"]]

  :plugins
  [[lein-figwheel "0.5.13"]
   [lein-cljsbuild "1.1.7"]]

  :repl-options
  {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

  :cljsbuild
  {:builds
   [{:id "dev"
     :figwheel true
     :source-paths ["src"]
     :compiler {:main "lisp-stack.core"
                :asset-path "js/out"
                :output-to "resources/public/js/script.js"
                :output-dir "resources/public/js/out"}}
    {:id "min"
     :source-paths ["src"]
     :compiler {:output-to "resources/public/js/script.js"
                :source-map-timestamp true
                :optimizations :advanced
                :pretty-print false}}]})
