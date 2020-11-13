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
                sh 'mvn compile install package -f ./algoprep/pom.xml'
            }
        }
    }
}
