FROM openjdk:8-jdk-alpine
MAINTAINER Konrad Gebczynski
ENV app_name target/simple-servlet.jar
ENV agent ./agent/

COPY ${app_name} simple-servlet.jar
COPY ${agent} /opt/agent/

EXPOSE 8080
ENTRYPOINT ["java","-javaagent:/opt/agent/javaagent.jar","-jar","simple-servlet.jar"]