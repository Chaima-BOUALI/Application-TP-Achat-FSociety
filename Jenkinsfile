pipeline {
    agent any
   tools{
        maven 'M2_HOME'
    }
   
    environment {
        // This can work with nexus3 or nexus2
       
        // This can be http or https
        NEXUS_PROTOCOL = "http"
        // Where your Nexus is running
        NEXUS_URL = "localhost:8083/Nexus"
        // Nexus repository where we will upload the artifact
        NEXUS_REPOSITORY = "Releases"
        // Jenkins credential id to authenticate to Nexus
        NEXUS_CREDENTIAL_ID = "admin:admin"
    }
    stages {

        stage("Cloning Repository") {
            steps {
                script {
                    // Let's clone the source
                     git branch: 'ChaymaBoualy', url: 'https://github.com/ChaymaBoualy/Application-TP-Achat-FSociety.git'                }
            }
        }
                


 stage('Build docker image') {
         steps{
             script{
                 sh 'docker build -t ChaymaBoualy/docker-spring-boot .'
             }
         }
     }
     stage('Push docker image'){
         steps{
             script{
                 withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                 sh 'docker login -u ChaymaBoualy -p ${dockerhubpwd}'
                }
                sh 'docker push ChaymaBoualy/docker-spring-boot'
             }
         }
         
     }
             stage("Building Project") {
            steps {
                script {
                    // Since we are using Windows we should Use "bat" step
                    // this step takes code and package it in its distributable format, such as a JAR
                    bat "mvn package -DskipTests=true"
                }
            }
        }

        stage("Cleaning Project") {
            steps {
                script {
                    //this step attempts to clean the files and directories generated by Maven during its build
                    bat "mvn clean"
                }
            }
        }

        stage("Testing stage") {
            steps {
                script {
                    // this step runs our JUnit tests through Maven
                    bat "mvn test"
                }
            }
        }

  	    stage("Sonar metrics") {
            steps {
                script {
                    // this step enable to execute the SonarQube analysis via a regular Maven goal
                    bat "mvn sonar:sonar "
                     }
                }
            } 
           
        stage("Deployment stage") {
            steps {
                script {
                    // this stage deploys the artifact into Nexus repository
                    bat "mvn deploy"
                }
            }
        }
        
        stage("Email Notification") {
          steps {
            // this step notifies collaborators about the build status 
            mail bcc: '', body: '''Hello User the build of your project successed.
             Jenkins.''', cc: '', from: '', replyTo: '', subject: 'Build succed', to: 'chayma.boualy@esprit.tn'
          }
        
        }       
}
    post { 
        always { 
                cleanWs()
                }
    }

}