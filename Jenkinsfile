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
        sh '''./gradlew clean
'''
        sh './gradlew assembleDebug'
        stash(name: 'app-debug', includes: 'app/build/outputs/**/*.apk')
      }
    }
    stage('Test') {
      steps {
        parallel(
          "Test": {
            sh './gradlew testDebugUnitTest'
            junit 'app/build/test-results/testDebugUnitTest/TEST-ca.aequilibrium.counters.ExampleUnitTest.xml'
            sh 'cat \'app/build/test-results/testDebugUnitTest/TEST-ca.aequilibrium.counters.ExampleUnitTest.xml\''
            
          },
          "Selenium": {
            input 'Waiting here ...'
            
          }
        )
      }
    }
    stage('Archive') {
      steps {
        archiveArtifacts '**/*.apk'
      }
    }
  }
}