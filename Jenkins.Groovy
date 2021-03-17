node {

   stage('checkout') {
       git 'https://github.com/Murail/jenkins.git'
       git 'https://github.com/ashokdevops01/maven.git'
   }
   stage('test'){
       sh 'mvn test -f spring-boot-samples/spring-boot-sample-atmosphere/pom.xml'
       sh 'mvn test -f web/pom.xml'
   }
   stage('Test reports'){
       junit 'spring-boot-samples/spring-boot-sample-atmosphere/target/surefire-reports/*.xml'
       junit 'web/*.xml'

   }
   stage('package'){

       sh 'mvn package -f spring-boot-samples/spring-boot-sample-atmosphere/pom.xml'
       sh 'mvn package -f web/pom.xml'

   }
   stage('archieve artifacts'){
       archiveArtifacts '-f spring-boot-samples/spring-boot-sample-atmosphere/target/*.*ar'
       archiveArtifacts '-f web/target/*.*ar'

   }
}
