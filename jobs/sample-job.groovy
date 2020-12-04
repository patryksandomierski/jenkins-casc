@Library('jenkins-shared')
import org.patsan.Sample

pipeline {

    agent any

    tools {
        maven 'Default'
    }

    stages {
        stage('prepare') {
            steps {
                script {
                    echo 'prepare'
                }
            }
        }

        stage('check shared library') {
            steps {
                script {
                    Sample sample = new Sample()
                    echo "${sample.sayHello()}"
                }
            }
        }

        stage('check maven installation') {
            steps {
                script {
                    sh 'mvn --version'
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
