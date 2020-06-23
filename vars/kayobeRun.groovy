/**
 * Something like this in the job:
 *
 * kayobeRun {
 *     echo "hi"
 *     sh "echo goodbye"
 * }
 *
 */
def call(body) {
    pipeline {
        agent any
        stages {
            stage('build') {
                steps {
                    body()
                }
            }
        }
    }
}