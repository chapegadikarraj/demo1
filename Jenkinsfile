//node {
pipeline {
   
    
   
   environment {
       registry = 'rajchape/demo1:1.0.0'
       registryCredential = 'dockerhub'
       dockerImage = ''
   }
   agent any
   stages {
      stage('Checkout Code') {
         steps {
            echo 'Checking out code from bitbucket...'
            git url: 'https://chapegadikarraj@bitbucket.org/chapegadikarraj/demo1.git'
            echo 'Checked out source code.'
         }
      }
      
      stage('Maven build And Run Unit Tests'){
          //def mvnHome = tool name: 'maven-3', type: 'maven'
          steps {
            
            echo 'Building Project...'
            //sh "${mvnHome}/bin/mvn clean install"
            //sh 'mvn clean install -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true'
            sh "mvn clean install"
            echo 'Project Build complete'
         }   
         
      }
      
      stage('Deploy to Server'){
         steps {
            
            echo 'Deploying Project...'
            //sh "${mvnHome}/bin/mvn clean install"
            //sh 'mvn clean install -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true'
            sshagent(credentials: ['ec2-user']) {
            	sh 'ssh ec2-user@ec2-3-14-6-42.us-east-2.compute.amazonaws.com rm -rf /home/ec2-user/demo-multibranch_main/target/'
				sh 'ssh ec2-user@ec2-3-14-6-42.us-east-2.compute.amazonaws.com mkdir -p /home/ec2-user/demo-multibranch_main/target/'
				sh 'scp -r /var/lib/jenkins/workspace/demo1_main/target ec2-user@ec2-3-14-6-42.us-east-2.compute.amazonaws.com:/home/ec2-user/demo1'
				sh 'ssh ec2-user@ec2-18-191-113-162.us-east-2.compute.amazonaws.com java -jar /home/ec2-user/demo1/Demo1-0.0.1-SNAPSHOT.jar'
            //sh "scp -o StrictHostKeyChecking-no 1-multibranch-github_development/target/Demo1-0.0.1-SNAPSHOT.war admin@18.221.115.64:/var/lib/tomcat/webapps"
            }
            //sh "curl -v -u admin:admin -T /var/lib/jenkins/workspace/demo-multibranch_main/target/Demo1-0.0.1-SNAPSHOT.jar 'http://ec2-18-223-159-90.us-east-2.compute.amazonaws.com:8080//manager/text/deploy?path=/demo1'"
            
            echo 'Deployment complete'
         }   
         
      }
      
      //stage('Deploy to Tomcat'){
         //steps {
            
            //echo 'Deploying Project...'
            //sh "${mvnHome}/bin/mvn clean install"
            //sh 'mvn clean install -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true'
            //sshagent(credentials: ['ec2-user']) {
            //sh "scp -o StrictHostKeyChecking-no 1-multibranch-github_development/target/Demo1-0.0.1-SNAPSHOT.war admin@18.221.115.64:/var/lib/tomcat/webapps"
            //}
            //sh "curl -v -u admin:admin -T /var/lib/jenkins/workspace/demo-multibranch_main/target/Demo1-0.0.1-SNAPSHOT.jar 'http://ec2-18-223-159-90.us-east-2.compute.amazonaws.com:8080//manager/text/deploy?path=/demo1'"
            //echo 'Deployment complete'
         //}   
         
      //}
      
      //stage('Sonar Quality Analysis'){
          //steps {
            //def mvnHome = tool name: 'maven-3', type: 'maven'
            //echo 'Beginning Sonar Scan...'
            //withSonarQubeEnv('sonar-6'){
                //sh "${mvnHome}/bin/mvn sonar:sonar"
                //sh "mvn sonar:sonar"
            //}
            //echo 'Scan Complete'
         //}
      //}
      
      //stage('SonarQube Quality Gate Check'){
          //steps {
            //timeout(time: 1, unit: 'HOURS'){
              //script{
                  //def qg = waitForQualityGate()
                  //if(!(qg.status == "OK") || qg.status == "WARN"){
                      //error "Pipeline aborted due to quality gate failure: ${qg.status}"
                  //} else {
                      //echo "PipeLine continued due to quality gate success: ${qg.status}"
                  //}
              //}
            //}
         //}
      //}
      
      //stage('Build Docker Image') {
          //steps {
              //echo 'Building Docker Image...'
                //script {
                  //dockerImage = docker.build("rajchape/demo1:1.0.0","-f Dockerfile .")
                  //docker.withRegistry("https://registry.hub.docker.com", "dockerhub")
                  //app.push()
                //}
              //echo 'Image Build Completed'
          //}
      //}
      
      //stage('Upload to DockerHub') {
          //steps {
          //echo 'Uploading to DockerHub...'
          //script {
              //docker.withRegistry("https://registry.hub.docker.com", 'dockerhub')
              //dockerImage.push()
          //}
          //echo 'Image Uploaded...'
          //}
      //}
   }
}
