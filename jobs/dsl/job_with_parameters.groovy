import util.Environments
import util.JobUtil

def job = pipelineJob("job-with-parameters") {
    description()
    keepDependencies(false)
    parameters {
        stringParam("VERSION", "", "version to deploy")
        choiceParam("ENVIRONMENT", Environments.main, "select environment to deploy")
        booleanParam("ENABLE_PROFILER", false, "check if you want to open ports for profiling")
    }
    disabled(false)
    properties {
        disableConcurrentBuilds()
    }
}

JobUtil.setDefinition(job, 'job-with-parameters.groovy')
