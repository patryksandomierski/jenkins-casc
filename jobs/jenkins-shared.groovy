pipeline {

    agent any

    tools {
        maven 'Default'
    }

    environment {
        RELEASE_BRANCH = 'main'
    }

    stages {
        stage('Build PR') {
            when { expression { env.BRANCH_NAME ==~ /PR-.*/ } }
            stages {
                stage('Compile') { steps { script { compile() } } }
                stage('Validate') { steps { script { test() } } }
            }
        }

        stage('Build Main') {
            when { branch env.RELEASE_BRANCH }
            stages {
                stage('Compile') { steps { script { compile() } } }
                stage('Validate') { steps { script { test() } } }
            }
        }
    }
}

private compile() {
    sh 'mvn clean compile'
}

private test() {
    sh 'mvn clean test'
}
