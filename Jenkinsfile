pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Compile') {
            steps {
                dir('maven-demo') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage('Build') {
            steps {
                dir('maven-demo') {
                    sh 'mvn package -DskipTests'
                }
            }
        }

        stage('Test') {
            steps {
                dir('maven-demo') {
                    sh 'mvn test'
                }
            }
        }
    }

    post {
        success {
            echo 'Build successful 🎉'
            archiveArtifacts artifacts: 'maven-demo/target/*.jar', fingerprint: true
            junit 'maven-demo/target/surefire-reports/*.xml'
        }
        failure {
            echo 'Build failed ❌'
        }
    }
}
