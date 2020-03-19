FROM openjdk:8
ADD target/docker-spring-bootv2.jar   docker-spring-bootv2.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","docker-spring-bootv2.jar"]


