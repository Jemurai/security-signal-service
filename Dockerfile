FROM java:8-alpine
MAINTAINER Matt Konda <mkonda@jemurai.com>

ADD target/security-signal-service-0.0.1-SNAPSHOT-standalone.jar /security-signal-service/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/security-signal-service/app.jar"]
