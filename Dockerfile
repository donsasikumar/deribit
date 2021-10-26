FROM openjdk:8-jdk-alpine
COPY target/deribit-0.0.1.jar deribit-0.0.1.jar
ENTRYPOINT ["java","-jar","/deribit-0.0.1.jar"]