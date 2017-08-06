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
        node(label: 'android') {
          sh '''ls -l
./gradlew clean
./gradlew assembleDebug
'''
        }
        
      }
    }
  }
}