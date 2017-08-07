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
        sh './gradlew build'
      }
    }
    stage('Test Report') {
      steps {
        junit './app/build/test-results/testDebugUnitTest/TEST-ca.aequilibrium.counters.ExampleUnitTest.xml'
      }
    }
    stage('Archive') {
      steps {
        archiveArtifacts '**/*.apk'
      }
    }
  }
}