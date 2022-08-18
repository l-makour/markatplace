node {

    environment {
        AWS_ACCESS_KEY     = credentials('test')
    }


    stage('checkout') {
        println AWS_ACCESS_KEY
        checkout([$class: 'GitSCM', branches: [[name: '*/develop']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/l-makour/marketplace.git']]]);
    }
    stage('unit-test') {
        sh 'chmod 777 mvnw && ./mvnw test'
    }
    stage('integ-test') {
        sh './mvnw test -P failsafe'
    }
    stage('build') {
        sh './mvnw clean package -DskipTests'
        stash includes: 'target/*.jar', name: 'livrable-mp'
        stash includes: 'Dockerfile', name: 'Dockerfile'
    }
    node('vm-int') {
        stage('build docker image & push') {
            unstash 'livrable-mp'
            unstash 'Dockerfile'
            sh 'sudo docker build -t mp .'
            sh 'sudo docker tag mp sbenbelkacem/mp:1.0'
            sh 'sudo docker login -u sbenbelkacem -p Samir@dockerhub'
            sh 'sudo docker push sbenbelkacem/mp:1.0'
        }
        stage('deploy application') {
            try {
                sh "sudo docker stop mp"
                sh "sudo docker rm mp"
                sh 'sudo docker run --name mp -p 8081:9090 -e SPRING_PROFILES_ACTIVE=int -d sbenbelkacem/mp:1.0'

            } catch (Exception e) {
                sh 'sudo docker run --name mp -p 8081:9090 -e SPRING_PROFILES_ACTIVE=int -d sbenbelkacem/mp:1.0'
            }

        }
    }
}
