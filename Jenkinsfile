pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
            }
        }
        stage('Copy the workdir to home') {
            steps {
                sh 'cp -r . /home'
            }
        }
        stage('Deploy') {
            when {
                branch 'production'
            }
            steps {
                echo 'Deploying....'
                sh 'make'
            }
        }
    }
}
