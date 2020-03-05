### Getting Started

A Basic Dockerized Springboot Maven application.

### Application URL
 
http://localhost:8080/greeting
http://localhost:8080/greeting?account=personal&id=123


 ### Build application
 mvn clean build
 
 ### Run Application
 
 mvn spring-boot:run
 
 ### Build Docker Image
 
 docker build -t telenor-assignment:1.0 .
 
 ### list all the iamges
 
 docker images
 
 
 ### Run Docker Image

docker run -p 5000:8080 telenor-assignment: 1.0
