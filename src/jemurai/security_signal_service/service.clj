(ns jemurai.security-signal-service.service
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.body-params :as body-params]
            [ring.util.response :as ring-resp]
            [clojure.tools.logging :as log]))

(defn home-page
  [request]
  (ring-resp/response "This is a security signal application.  Post to /signal."))

(defn signal
  [request]
  ; Long run, log to DB, syslog, whatever.
  (log/error "Signal" request) 
  (ring-resp/response (:params "ya" request)))

(def common-interceptors [(body-params/body-params) http/html-body])

(def routes #{["/" :get (conj common-interceptors `home-page)]
              ["/signal" :post (conj common-interceptors `signal)]})

(def service {:env :prod
              ::http/routes routes
              ::http/type :jetty
              ::http/port 8000
              ::http/container-options {:h2c? true
                                        :h2? false
                                        ;:keystore "test/hp/keystore.jks"
                                        ;:key-password "password"
                                        ;:ssl-port 8443
                                        :ssl? false
                                        }})
