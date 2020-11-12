pipeline {
    agent {
        label 'docker-labs'
    }

    stages {
        stage('Build') { 
            steps {
                sh 'mvn compile install package -f ./javaWeb/pom.xml' 
            }
        }
        stage('Deliver') {
            steps {
                sh 'ls javaWeb/'
            }
        }
    }
}
