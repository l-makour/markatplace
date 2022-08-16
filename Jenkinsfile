node{
    stage("checkout"){
        checkout([$class: 'GitSCM', branches: [[name: '*/develop']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/l-makour/marketplace.git']]])
    }
    stage("build"){
        sh "chmod 777 ./mvnw && ./mvnw clean package"

    }
    stage("test 3"){

    }
}
