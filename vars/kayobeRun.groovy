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
                        // needs to be in script body otherwise you get: Method calls on objects not allowed outside
                        // "script" blocks.
                        body()
                    }
                }
            }
        }
    }
}