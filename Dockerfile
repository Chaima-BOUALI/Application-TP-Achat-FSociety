FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:0000 -o achat.jar "http://192.168.56.3:8081/repository/maven-releases/com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar" -L
ENTRYPOINT ["java","-jar","/achat.jar"]
EXPOSE 8089
