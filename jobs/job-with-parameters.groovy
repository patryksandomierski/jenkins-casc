pipeline {

    agent any

    stages {
        stage('-') {
            steps {
                script {
                    echo "version: ${params.VERSION}"
                    echo "env: ${params.ENVIRONMENT}"
                    echo "profiler?: ${params.ENABLE_PROFILER}"
                }
            }
        }
    }
}
