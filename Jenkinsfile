pipeline {
    agent {
          label 'docker-labs'
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
        stage('Upload-Artifact') {
           def server = Artifactory.server 
           def buildInfo = Artifactory.newBuildInfo()
           buildInfo.env.capture = true
           buildInfo.env.collect() 

           def uploadSpec = """{
             "files": [
              {
                 "pattern": "**/target/*.jar",
                 "target": "java-repository-local"
              }
            ]
           }"""
           server.upload spec: uploadSpec, buildInfo: buildInfo
           buildInfo.retention maxBuilds: 10, maxDays: 7, deleteBuildArtifacts: true
           server.publishBuildInfo buildInfo 

        }

    }
}
