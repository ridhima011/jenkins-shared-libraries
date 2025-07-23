def call(String projectName,String imageTag,String dockerhubUser){
  sh "docker build -t ${dockerhubUser}/${projectName}:${imageTag} ."
}
