pipeline {

    agent any

    stages {
        stage('prepare') {
            steps {
                script {
                    echo 'prepare'
                }
            }
        }

        stage('build') {
            steps {
                script {
                    echo 'build'
                }
            }
        }

        stage('deploy') {
            steps {
                script {
                    echo 'deploy'
                }
            }
        }
    }

    post {
        unsuccessful {
            script {
                echo 'job was not successful'
            }
        }
    }
}
