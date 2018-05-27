(ns site.core
  (:require [hiccup.page :as hp])
  (:require [markdown-to-hiccup.core :as m]))

(defn page [data]
  (hp/html5 "
<head>
    <meta charset=\"UTF-8\">
    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">
    <style>
       @import url('https://fonts.googleapis.com/css?family=Roboto:100i');
    </style>
</head>  
"
            [:div {:style "max-width: 900px; margin: 40px auto;"}
             (-> data :entry :content)
             (-> "resources/footer.markdown" m/file->hiccup m/component)]))
