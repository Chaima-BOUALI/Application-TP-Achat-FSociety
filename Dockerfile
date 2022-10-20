FROM openjdk:8-jdk-DEVOPS-Pipeline-TPAchat
EXPOSE 8083
ADD target/DEVOPS-Pipeline-TPAchat.jar DEVOPS-Pipeline-TPAchat.jar
ENTRYPOINT ["java","-jar","/docker-spring-boot.jar"]