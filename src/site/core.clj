(ns site.core
  (:require [hiccup.page :as hp])
  (:require [markdown-to-hiccup.core :as m]))

(defn page [data]
  (hp/html5 "
<head>
    <meta charset=\"UTF-8\">
    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">
    <link href=\"./css/style.css\" rel=\"stylesheet\" type=\"text/css\">
    <link href=\"./css/raw_style.css\" rel=\"stylesheet\" type=\"text/css\">
    <style>
       @import url('https://fonts.googleapis.com/css?family=Roboto:100i');
    </style>
</head>  
"
            [:body [:div {:style "max-width: 900px; margin: 40px auto;"}
                    (-> data :entry :content)
                    [:div {:id "app"}]
                    [:canvas {:id "hello-quil"}]
                    (-> "resources/footer.markdown" m/file->hiccup m/component)]
             [:script {:src "./js/compiled/withering_spell.js" :type "text/javascript"}]
             "<script type=\"text/javascript\">withering_spell.system.go();</script>"
             "    <script type=\"text/javascript\">withering_spell.quilcore.run_sketch()</script>"]))
