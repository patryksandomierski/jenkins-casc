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
        def traits = it / sources / data / 'jenkins.branch.BranchSource' / source / traits
        traits << 'org.jenkinsci.plugins.github__branch__source.BranchDiscoveryTrait' {
            strategyId(3)
        }
        traits << 'org.jenkinsci.plugins.github__branch__source.OriginPullRequestDiscoveryTrait' {
            strategyId(1)
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
}
