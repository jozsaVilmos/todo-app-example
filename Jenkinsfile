pipeline {
    agent any
    tools {
        gradle "Alopex Malac Gradle"
    }
    stages {
        stage('Gradle') {
            steps {
                sh 'gradle build'
            }
        }
    }
}