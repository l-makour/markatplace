node {
    stage("checkout") {
        checkout([$class: 'GitSCM', branches: [[name: '*/feature02']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/l-makour/marketplace']]])
    }
    stage("build") {
        sh "chmod 777 ./mvnw && ./mvnw -DskipTests=true clean package"
    }
    stage("unit-test") {
        sh "chmod 777 ./mvnw && ./mvnw test"
    }

  stage("integration-test") {
    sh "chmod 777 ./mvnw && ./mvnw test -Pintegration-test"
  }
    stage("deploy") {
    }

}