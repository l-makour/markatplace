node  {
stage("checkout"){
checkout([$class: 'GitSCM', branches: [[name: '*/feature02']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/l-makour/marketplace']]])
}
stage("build"){
  sh "chmod 777 ./mvnw && ./mvnw clean package"
}
stage("deploy"){
}

}