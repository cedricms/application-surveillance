FROM openjdk:8-jre-alpine
COPY target/postgres-ping*.war /postgres-ping.war
CMD ["/usr/bin/java", "-jar", "/postgres-ping.war"]
