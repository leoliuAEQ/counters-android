pipeline {
  agent any
  
  options {
    skipDefaultCheckout() 
  }
  
  stages {
    stage('Greetings') {
      steps {
        sh 'hostname'
        echo 'Hello.'
      }
    }
    stage('Build') {
      agent {
        node {
          label 'android-sdk'
        }
      }
      steps {
        sh 'hostname'
        sh './gradlew clean'
        sh './gradlew assembleDebug'
        stash(name: 'app-debug', includes: 'app/build/outputs/**/*.apk')
        sh './gradlew testDebugUnitTest'
        sh 'cat app/build/test-results/testDebugUnitTest/TEST-ca.aequilibrium.counters.ExampleUnitTest.xml'
        junit 'app/build/test-results/testDebugUnitTest/TEST-ca.aequilibrium.counters.ExampleUnitTest.xml'
      }
    }
    stage('Appium') {
      agent {
        node {
          label 'android-appium'
        }
      }
      steps {
        sh 'hostname'
        sh 'pwd'
        sh 'ls -lR'
        unstash 'app-debug'
        sh 'ls -lR'
      }
    }
    stage('Archive') {
      steps {
        sh 'hostname'
        sh 'pwd'
        sh 'ls -lR'
        unstash 'app-debug'
        sh 'ls -lR'
        archiveArtifacts '**/*.apk'
      }
    }
  }
}
