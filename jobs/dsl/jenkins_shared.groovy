multibranchPipelineJob('jenkins-shared') {
    displayName('jenkins-shared')
    branchSources {
        github {
            id('jenkins-shared')
            repoOwner('patryksandomierski')
            repository('jenkins-casc')
        }
    }
    configure {
        def traitBlock = it / 'sources' / 'data' / 'jenkins.branch.BranchSource' / 'source' / 'traits'
        traitBlock << 'jenkins.plugins.git.traits.BranchDiscoveryTrait' {}
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
