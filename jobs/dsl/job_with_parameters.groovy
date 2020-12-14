import util.Environments

pipelineJob("job-with-parameters") {
    description()
    keepDependencies(false)
    parameters {
        stringParam("VERSION", "", "version to deploy")
        choiceParam("ENVIRONMENT", Environments.main, "select environment to deploy")
        booleanParam("ENABLE_PROFILER", false, "check if you want to open ports for profiling")
    }
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
            scriptPath("jobs/job-with-parameters.groovy")
            lightweight(true)
        }
    }
    disabled(false)
    properties {
        disableConcurrentBuilds()
    }
}
