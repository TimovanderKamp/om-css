(defproject untangled/om-css "1.0.1-SNAPSHOT"
  :description "A composable library for co-located CSS on Om/Untangled UI components"
  :url ""
  :license {:name "MIT"
            :url  "https://opensource.org/licenses/MIT"}

  :dependencies [[org.clojure/clojure "1.9.0-alpha13" :scope "provided"]
                 [org.clojure/clojurescript "1.9.229" :scope "provided"]
                 [org.omcljs/om "1.0.0-alpha45" :scope "provided"]
                 [garden "1.3.2"]
                 [com.rpl/specter "0.13.0"]
                 [navis/untangled-spec "0.3.7-1" :scope "test"]
                 [navis/untangled-client "0.5.7-SNAPSHOT" :scope "provided"]]

  :plugins [[lein-cljsbuild "1.1.4"]]

  :source-paths ["src"]
  :resource-paths []
  :clean-targets ^{:protect false} ["resources/public/js" "target"]

  :cljsbuild {:builds [{:id           "dev"
                        :source-paths ["src" "test"]
                        :figwheel     true
                        :compiler     {:main          om-css.suite
                                       :output-to     "resources/public/js/specs/specs.js"
                                       :output-dir    "resources/public/js/compiled/specs"
                                       :asset-path    "js/compiled/specs"
                                       :optimizations :none}}]}

  :profiles {:dev {:source-paths   ["src" "dev"]
                   :resource-paths ["src" "resources"]
                   :dependencies   [[binaryage/devtools "0.5.2"]
                                    [com.cemerick/piggieback "0.2.1"]
                                    [figwheel-sidecar "0.5.5" :exclusions [org.clojure/tools.nrepl]]]}}

  :repl-options {:init-ns          user
                 :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]})
