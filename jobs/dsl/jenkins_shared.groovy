multibranchPipelineJob('jenkins-shared') {
    displayName('jenkins-shared')
    branchSources {
        git {
            id('jenkins-shared')
            remote('https://github.com/patryksandomierski/jenkins-casc.git')
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
