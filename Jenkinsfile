pipeline {
  agent any
  stages {
    stage('Greetings') {
      steps {
        sh 'hostname'
        echo 'Hello.'
      }
    }
    stage('Build') {
      steps {
        agent {
          node {
            label 'android-sdk'
          }
        }
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
      steps {
        agent {
          node {
            label 'android-appium'
          }
        }
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
