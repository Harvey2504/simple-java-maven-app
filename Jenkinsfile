pipeline {
    agent any
     triggers{
        pollSCM('* * * * *')
    }
    
    tools{
            maven 'maven-3'
    }
    
    stages {
        stage('Maven-Clean'){
            steps{
                sh 'mvn clean'
            }
        }
        stage('Maven-Compile'){
            steps{
                sh 'mvn compile'
            }
        }
        stage('Maven-test'){
            steps{
                sh 'mvn test'
            }
        }
        stage('Maven-Package'){
            steps{
                sh 'mvn package'
            }
        }
    }
    
     post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                       }
         
            }
}