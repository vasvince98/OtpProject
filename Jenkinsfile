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
                sh 'sudo cp -r . /home'
            }
        }
        stage('Deploy') {
            when {
                branch 'production'
            }
            steps {
                echo 'Deploying....'
                sh 'cd /home'
                sh 'make'
            }
        }
    }
}
