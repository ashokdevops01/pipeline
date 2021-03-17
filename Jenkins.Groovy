pipeline {
    agent any
   
    stages {
   
   stage('checkout') {
       git 'https://github.com/ashokdevops01/maven.git'
   }
   stage('test'){
       sh 'mvn test -f web/pom.xml'
   }
   stage('Test reports'){
       junit 'web/*.xml'
       
   }
   stage('package'){
       
       sh 'mvn package -f web/pom.xml'
       
   }
  
}
}

