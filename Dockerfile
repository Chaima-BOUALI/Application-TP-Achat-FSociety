FROM openjdk:8-jdk-pipelinetpachatfsociety
EXPOSE 8083
ADD target/pipelinetpachatfsociety.jar pipelinetpachatfsociety.jar
ENTRYPOINT ["java","-jar","/pipelinetpachatfsociety.jar"]