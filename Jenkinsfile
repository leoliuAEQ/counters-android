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
        sh '''uname -a
hostname
ls -l'''
      }
    }
  }
}