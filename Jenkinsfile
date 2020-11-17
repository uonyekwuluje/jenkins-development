pipeline {
    agent {
          label 'docker-labs'
    }

    environment {
      def uploadSpec = """{
        "files": [
         {
          "pattern": "**/target/*.jar",
          "target": "java-repository-local"
         } 
        ]
      }"""
    }

    stages {
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
        stage('Upload') {
            steps {
                echo 'Publish the artifacts..'
                sh 'mkdir -p downloads'
                    script
                        {
                        //def server = Artifactory.newServer('http://10.213.243.17:8081/artifactory', 'admin', 'art@123')
                        def server = Artifactory.server 'jfrog-artifactory-server'
                        server.bypassProxy = true
                        server.upload(uploadSpec)
                        echo 'Uploaded the file to Jfrog Artifactory successfully'
                        }
            }
        }
        /*stage('Notify') {
            steps {
                echo 'Mail Notification...'
                mail body: 'Project build successful for job named testpipeline-1',
                from: 'uionyekwuluje@gmail.com',
                subject: 'project build successful',
                to: 'uionyekwuluje@gmail.com'
            }
        }*/
    }
}
