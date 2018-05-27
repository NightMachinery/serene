(ns site.core
  (:require [hiccup.page :as hp])
  (:require [markdown-to-hiccup.core :as m]))

(defn page [data]
  (hp/html5 "<meta charset=\"UTF-8\">
<style>
@import url('https://fonts.googleapis.com/css?family=Roboto:100i');
</style>"
            [:div {:style "max-width: 900px; margin: 40px auto;"}
             (-> data :entry :content)
             (-> "resources/footer.markdown" m/file->hiccup m/component)]))
