pipeline {
    agent any
	
 //   environment {
  //      DOCKERHUB_CREDENTIALS=credentials('dockerhub')
 //   }

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
        
	  stage("Building image") {
            steps {
                sh 'docker build -t projet-devops .'
            }
        }
	  stage('pushing Image'){
           steps{
             script{
           sh 'docker login -u "dhafer01" -p "dhafer123." docker.io'
           sh 'docker tag projet-devops dhafer01/projet-devops'
           sh ' docker push dhafer01/projet-devops'
}
}
}
        
	stage('deploy docker-compose'){
            steps{
                script{
                    sh 'docker-compose up -d'
                }
            }
       
        }    
	
       
    }
	post {
		always {
			sh 'docker logout'
		}
        
	}
} 
       
        
     
