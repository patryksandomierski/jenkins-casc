multibranchPipelineJob('jenkins-shared') {
    displayName('jenkins-shared')
    branchSources {
        git {
            id('jenkins-shared')
            remote('https://github.com/patryksandomierski/jenkins-casc.git')
        }
    }
    configure {
        def traits = it / sources / data / 'jenkins.branch.BranchSource' / source / traits
        traits << 'com.cloudbees.jenkins.plugins.bitbucket.BranchDiscoveryTrait' {
            strategyId(1) // detect all branches -refer the plugin source code for various options
        }
        traits << 'com.cloudbees.jenkins.plugins.bitbucket.OriginPullRequestDiscoveryTrait' {
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
    triggers {
        cron('*/30 * * * *')
    }
}
