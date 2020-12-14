package util

class JobUtil {
    static void setDefinition(def job, def scriptName) {
        job.with {
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
                    scriptPath("jobs/${scriptName}")
                    lightweight(true)
                }
            }
        }
    }
}
