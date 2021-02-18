pipeline {
    agent any
     triggers{
        pollSCM('* * * * *')
    }
    
    tools{
            maven 'maven-3'
            jdk  'java11'
    }
    
    stages {
        stage('Maven-Clean'){
            steps{
                bat 'mvn clean'
            }
        }
        stage('Maven-Compile'){
            steps{
                bat 'mvn compile'
            }
        }


 stage('Package & SonarQube analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    
                     bat 'mvn package -DskipTests sonar:sonar'
			// bat 'mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar'
                    
                }
            }
        }


    }
    
}
