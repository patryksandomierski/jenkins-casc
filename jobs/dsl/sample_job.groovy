pipelineJob("sample-job") {
    description()
    keepDependencies(false)
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url("https://github.com/patryksandomierski/jenkins-casc.git")
                    }
                    branch("main")
                }
            }
            scriptPath("jobs/sample-job.groovy")
            lightweight(true)
        }
    }
    disabled(false)
    properties {
        disableConcurrentBuilds()
    }
}
