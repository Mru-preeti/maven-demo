pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK22'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Compile') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        success {
            echo 'Build successful 🎉'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            junit 'target/surefire-reports/*.xml'
        }
        failure {
            echo 'Build failed ❌'
        }
    }
}
