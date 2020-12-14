package util

interface Environments {
    /** main environments for ci/cd */
    def static final main = ['test', 'stage', 'prod']
}
