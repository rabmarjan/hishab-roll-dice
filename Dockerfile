FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} hishab.jar
ENTRYPOINT ["java","-jar","/hishab.jar"]