@Library('jenkins-shared')
import org.patsan.SecretEncryptor

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
                    // this is only example, store password as credentials in Jenkins
                    String password = 'sample-password'
                    String value = 'value-to-encrypt'
                    echo "we will encrypt value: ${value}"
                    SecretEncryptor encryptor = new SecretEncryptor(password)
                    String encryptedValue = encryptor.encrypt(value)
                    echo "encrypted: ${encryptedValue}"
                    String decryptedValue = encryptor.decrypt(encryptedValue)
                    echo "and decrypted: ${decryptedValue}"
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
