FROM openjdk:8
MAINTAINER Anusha, anusharp97@gmail.com
VOLUME /tmp
ADD target/docker-backend.jar docker-backend.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "docker-backend.jar"]
