/**
 * Something like this in the job:
 *
 * kayobeRun {
 *     echo "hi"
 *     sh "echo goodbye"
 * }
 *
 */
@Grab(group='org.yaml', module='snakeyaml', version='1.5')
import org.yaml.snakeyaml.Yaml

def call(Closure body) {
    Yaml yaml = new Yaml();
    def file = new File('/tmp/test.yml')
    def config = yaml.load(file.text)
    println(config)
    pipeline {
        agent any
        stages {
            stage('build') {
                steps {
                    script {
                        echo "${config.test}"
                        // needs to be in script body otherwise you get: Method calls on objects not allowed outside
                        // "script" blocks.
                        body()
                    }
                }
            }
        }
    }
}
