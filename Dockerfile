FROM tomcat:11.0-jdk21-openjdk-bookworm

COPY target/LoggingService-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
COPY server.xml /usr/local/tomcat/conf/server.xml

EXPOSE 7070