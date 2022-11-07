pipeline {
    agent any
	
    environment {
        DOCKERHUB_CREDENTIALS=credentials('dockerhub')
    }

    stages {
        stage("git pull"){
            steps{
              
                git branch: 'stockBack', 
                credentialsId: '91ccda11-c578-4756-b7a8-d912db0bed6d', 
                url: 'https://github.com/ChaymaBoualy/Application-TP-Achat-FSociety.git'
                    
                }
                
            }
      //  stage("MVN CLEAN"){
     //       steps{
              
           //     sh 'mvn clean package'
                             
           //     }
                
         //   }
        stage("MVN TEST"){
            steps{
              
                sh 'mvn clean test'
                             
                }
                
            }
        stage("build"){
            steps{
              
                sh 'mvn install package'
                             
                }
                
            }
        
	}
} 
       
        
     
