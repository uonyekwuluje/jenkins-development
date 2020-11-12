pipeline {
    agent {
        label 'docker-labs'
        docker { image 'cloudbees/jnlp-slave-with-java-build-tools' }
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
