(defproject jemurai.security-signal-service "0.0.1-SNAPSHOT"
  :description "A service to collect app security signal"
  :url "https://github.com/Jemurai/security-signal-service"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [io.pedestal/pedestal.service "0.5.7"]
;                 [io.pedestal/pedestal.jetty "0.5.1"]  ; This is vulnerable to lots of things.
                 [io.pedestal/pedestal.jetty "0.5.7"]
                 [ch.qos.logback/logback-classic "1.2.3" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jul-to-slf4j "1.7.26"]
                 [org.slf4j/jcl-over-slf4j "1.7.26"]
                 [org.slf4j/log4j-over-slf4j "1.7.26"]
                 [org.clojure/tools.logging "0.5.0"]
                 [org.clojure/java.jdbc "0.7.10"]
;                 [hiccup "1.0.5"]  ; This was used when we wanted to play with hiccup templating.
                 ]
  :min-lein-version "2.0.0"
  :resource-paths ["config", "resources"]
  :plugins [[com.livingsocial/lein-dependency-check "1.1.3"]]
  ;; If you use HTTP/2 or ALPN, use the java-agent to pull in the correct alpn-boot dependency
  ;:java-agents [[org.mortbay.jetty.alpn/jetty-alpn-agent "2.0.5"]]
  :profiles {:dev {:aliases {"run-dev" ["trampoline" "run" "-m" "jemurai.security-signal-service.server/run-dev"]}
                   :dependencies [[io.pedestal/pedestal.service-tools "0.5.7"]]}
             :uberjar {:aot [jemurai.security-signal-service.server]}}
  :main ^{:skip-aot true} jemurai.security-signal-service.server)


