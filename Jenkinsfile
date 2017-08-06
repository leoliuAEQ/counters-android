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
        timestamps()
      }
    }
  }
}