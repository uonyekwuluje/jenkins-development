pipeline {
    agent {
          label 'docker-labs'
    }

    stages {
        stage('WebProject') { 
            steps {
                sh 'mvn compile install package -f ./javaWeb/pom.xml' 
            }
        }
        stage('AlgoPrep-DataStructure') {
            steps {
                sh 'mvn clean compile install assembly:single -f ./algoprep/pom.xml'
                sh 'java -jar ./algoprep/target/algoprep-1.0-SNAPSHOT-jar-with-dependencies.jar'
            }
        }
    }
}
