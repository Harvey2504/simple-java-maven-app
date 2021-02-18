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
        stage('Maven-Verify & SonarScan'){
            steps{
                bat 'mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar'
            }
        }

    }
    
}
