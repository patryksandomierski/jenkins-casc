@Library('jenkins-shared')
import org.patsan.Sample

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
                    Sample sample = new Sample()
                    echo "${sample.sayHello()}"
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
