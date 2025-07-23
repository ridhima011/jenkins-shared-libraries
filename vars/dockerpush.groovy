def call(String imageName,String tag="latest",String dockerhubCredId="dockerhubCred"){
      withCredentials([usernamePassword(
        credentialsId: dockerhubCredId,
        usernameVariable: 'dockerhubUser', 
        passwordVariable: 'dockerhubPass')]) {
            
        sh """
            echo \$dockerhubPass | docker login -u \$dockerhubUser --password-stdin
            docker tag ${imageName}:${tag} \$dockerhubUser/${imageName}:${tag}
            docker push \$dockerhubUser/${imageName}:${tag}
        """
    }
}    
