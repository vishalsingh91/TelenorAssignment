FROM java:8-jdk-alpine

COPY ./target/TelenorAssignment-0.0.1-SNAPSHOT.jar C:/opt/

WORKDIR C:/opt/

RUN sh -c 'touch TelenorAssignment-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","TelenorAssignment-0.0.1-SNAPSHOT.jar"]