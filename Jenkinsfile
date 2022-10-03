pipeline {
    agent any
    tools{
        maven 'maven'
    }
    stages {
        stage('Build jar file') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/AlenGalindo/sistema-sueldos-mingeso']]])
                sh 'mvn package -DskipTests'
            }
        }
        stage('Build docker image'){
            steps {
                sh 'docker build -t alengalindo/mi-app-tingeso .'
            }
        }
        stage('Push docker image'){
            steps {
                script{

                    withCredentials([string(credentialsId: 'dckr-password', variable: 'password')]) {
                        sh 'docker login -u alengalindo -p ${password}'
}

                    sh 'docker push alengalindo/mi-app-tingeso'
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