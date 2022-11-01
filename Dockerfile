FROM maven:3.8.2-jdk-8
RUN apt-get install curl
RUN curl -u admin:chayma -o achat2.jar "http://192.168.56.3:8081/repository/maven-releases/com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar" -L
ENTRYPOINT ["java","-jar","/achat2.jar"]
