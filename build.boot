(set-env!
 :source-paths #{"src" "content" "resources"}
 :dependencies '[[perun  "0.3.0" :scope "test"]
                 [hiccup "1.0.5"]
                 [kanwei/boot-http "0.7.4"]
                 [markdown-to-hiccup "0.3.0"]])

(require '[io.perun :refer :all]
         '[pandeiro.boot-http :refer [serve]])
