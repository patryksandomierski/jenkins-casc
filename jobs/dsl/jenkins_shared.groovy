multibranchPipelineJob('jenkins-shared') {
    displayName('jenkins-shared')
    branchSources {
        github {
            id('jenkins-shared')
            repository('https://github.com/patryksandomierski/jenkins-casc.git')
        }
    }
    factory {
        workflowBranchProjectFactory {
            scriptPath('jobs/jenkins-shared.groovy')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            daysToKeep(1)
        }
    }
    triggers {
        cron('*/30 * * * *')
    }
}
