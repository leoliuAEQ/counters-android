pipeline {
  agent none
  
  options {
    skipDefaultCheckout() 
  }
  
  stages {
    stage('Build') {
      agent {
        node {
          label 'android-sdk'
        }
      }
      steps {
        checkout scm
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
      agent any
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
