pipeline {
    agent any
    tools{
        maven 'maven'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/sazzad45/spring-qr']]])
                sh 'mvn clean install'
            }
        }
    }
	stage('Build docker image'){
            steps{
                script{
				    
                    sh 'docker build -t fast-pay-qr .'
                }
            }
        }
}
