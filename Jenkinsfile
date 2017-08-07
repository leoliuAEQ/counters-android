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
        sh 'hostname'
        sh 'date'
        sh './gradlew clean'
        sh './gradlew assembleDebug'
      }
    }
  }
}