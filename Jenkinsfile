node {
    stage("checkout") {
        checkout([$class: 'GitSCM', branches: [[name: '*/feature02']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/l-makour/marketplace']]])
    }

    stage("unit-test") {
        sh "chmod 777 ./mvnw && ./mvnw test"
    }

    stage("integration-test") {
        sh "chmod 777 ./mvnw && ./mvnw test -Pintegration-test"
    }
    stage("build") {
        sh "chmod 777 ./mvnw && ./mvnw -DskipTests=true clean package"
    }

    node("vm-int-lma")
            {
                stage("copy-files")
                        {
                            stash includes: 'target/**.jar', name: 'livrable'
                            stash includes: 'Dockerfile', name: 'Dockerfile'
                            unstash 'livrable'
                            unstash 'Dockerfile'
                        }
                stage("build-image-docker")
                        {
                          sh "sudo docker build -t marketplace ."
                          sh "sudo docker tag marketplace lmakour/marketplace:1.0"
                        }
                stage("login-push-image")
                        {
                            sh "sudo docker build -t marketplace:1.0 ."
                            sh "sudo docker login -u lmakour -p Med@sys01"
                            sh "sudo docker push lmakour/marketplace:1.0"
                        }
                stage("pull-run-image")
                        {
                            sh "sudo docker pull lmakour/marketplace:1.0"
                            sh "sudo docker run --name marketplacelma -p 8080:8080 -d lmakour/marketplace:1.0"
                        }
            }

}