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
                    branch("*/master")
                }
            }
            scriptPath("jobs/sample-job.groovy")
            lightweight(true)
        }
    }
    disabled(false)
    properties {
        pipelineTriggers {
            triggers {
                cron {
                    spec('H 2 * * *')
                }
            }
        }
        disableConcurrentBuilds()
    }
}
