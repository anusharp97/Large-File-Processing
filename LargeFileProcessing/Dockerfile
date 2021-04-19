FROM openjdk:8
ADD target/docker-backend.jar docker-backend.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "docker-backend.jar"]
