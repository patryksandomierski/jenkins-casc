package util

interface Environments {
    /** main environments for ci/cd */
    static final ArrayList<String> main = ['test', 'stage', 'prod']
}
