pipeline {
    agent any
    triggers{
        pollSCM('* * * * *')
    }
    
    tools{
            maven 'maven-3'
            jdk 'java11'
    }
    //Nothing Interesting Happening
    stages {
        stage('clean')
        {
            steps{
            bat 'mvn clean'
            }
        }
        stage('build && SonarQube analysis') {
            steps {
                withSonarQubeEnv('sonarqube2') {
                    
                        bat 'mvn package sonar:sonar'
                    
                }
            }
        }
    }
    
}
