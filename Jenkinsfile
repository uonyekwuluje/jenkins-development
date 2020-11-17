pipeline {
    agent {
          label 'docker-labs'
    }

    stages {
        stage ('checkout') {
            checkout scm
        }
        stage('Build-WebProject') { 
            steps {
                sh 'mvn compile install package -f ./javaWeb/pom.xml' 
            }
        }
        stage('Build-AlgoPrep-DataStructure') {
            steps {
                sh 'mvn clean compile install assembly:single -f ./algoprep/pom.xml'
            }
        }
        stage('Test-AlgoPrep-DataStructure') {
            steps {
                sh 'java -jar ./algoprep/target/algoprep-1.0-SNAPSHOT-jar-with-dependencies.jar'
            }
        }
    }
}
