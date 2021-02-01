FROM openjdk:8-jre-alpine
COPY target/postgres-ping*.jar /postgres-ping.jar
CMD ["/usr/bin/java", "-jar", "/postgres-ping.jar"]
