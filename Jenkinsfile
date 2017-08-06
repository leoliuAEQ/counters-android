pipeline {
  agent any
  stages {
    stage('Greetings') {
      steps {
        echo 'Hello.'
      }
    }
    stage('Build') {
      steps {
        node(label: 'android')
        sh './gradlew clean'
        sh './gradlew assembleDebug'
      }
    }
  }
}