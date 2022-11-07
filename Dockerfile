FROM openjdk:11
EXPOSE 8082
ADD target/springprojet-1.0.jar springprojet-1.0.jar
ENTRYPOINT ["java","-jar","/springprojet-1.0.jar"]
