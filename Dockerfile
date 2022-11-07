FROM maven:3.8.2-jdk-8
ARG JAR_FILE=/1.0-SNAPSHOT/*.jar
RUN apt-get install curl
RUN curl -u admin:vagrant -o achat.jar "http://192.168.1.38:8081/repositories/maven-releases/com/esprit/examen/tpAchatProject/1.0-SNAPSHOT/tpAchatProject-1.0.jar" -L
ENTRYPOINT ["java","-jar","/achat.jar"]
EXPOSE 8082