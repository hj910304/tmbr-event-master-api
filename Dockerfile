FROM openjdk:8-jre-alpine
COPY target/tmbr-event-master-api-0.0.1-SNAPSHOT.war /app.war 
# run application with this command line 
CMD ["/usr/bin/java", "-jar", "/app.war"]
