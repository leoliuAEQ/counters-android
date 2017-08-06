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
        sh '''hostname
date'''
        sh '''./gradlew clean
./gradlew assembleDebug'''
      }
    }
  }
}