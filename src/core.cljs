(ns lisp-stack.core
  (:require
   [reagent-forms.core :refer [bind-fields]]
   [reagent.core :as r]))

(defonce state (r/atom {}))

(defn app []
  [bind-fields [:input {:field :text, :id :code}] state])

(r/render [app] (js/document.getElementById "app"))
