pipeline {
  agent {
    node {
      label 'android'
    }
    
  }
  stages {
    stage('Greetings') {
      steps {
        echo 'Hello.'
      }
    }
    stage('Build') {
      steps {
        sh '''name -a
hostname
ls -l'''
      }
    }
  }
}