pipeline {
    agent { docker { image 'gradle:latest' } }
    stages {
        stage('Gradle') {
            steps {
                sh 'gradle --version'
            }
        }
    }
}
