(ns lisp-stack.core
  (:require
   [cljs.reader :as reader]
   [reagent-forms.core :refer [bind-fields]]
   [reagent.core :as r]))

(defonce state (r/atom {}))
(defn deep-render [term]
  [:div (if (and (coll? term) (not (empty? term)))
         (map deep-render term)
         [:span.term (pr-str term)])])
(defn app []
  [:div
   [bind-fields [:input {:field :text, :id :code}] state]
   [:div.vis (deep-render (try (reader/read-string (:code @state))
                           (catch js/Error e '())))]])

(r/render [app] (js/document.getElementById "app"))
