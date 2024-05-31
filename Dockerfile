FROM openjdk:17-jdk-alpine
RUN mkdir /app
WORKDIR /app
COPY target/*.jar /app/appcliente.java
CMD [ "java", "-jar", "/app/appcliente.java" ]