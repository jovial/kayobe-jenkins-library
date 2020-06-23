/**
 * Something like this in the job:
 *
 * kayobeRun {
 *     echo "hi"
 *     sh "echo goodbye"
 * }
 *
 */
def call(Closure body) {
    pipeline {
        agent any
        stages {
            stage('build') {
                steps {
                    script {
                        body()
                    }
                }
            }
        }
    }
}