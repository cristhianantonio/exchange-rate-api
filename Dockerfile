FROM adoptopenjdk/openjdk11:alpine-jre
COPY target/exchangerateapi-1.0.0-SNAPSHOT.jar exchange-rate-api.jar
ENTRYPOINT ["java","-jar","/exchange-rate-api.jar"]