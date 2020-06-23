package com.stackhpc.kayobe

import testSupport.PipelineSpockTestBase

/**
 * How to unit test some vars DSL like shared code
 */
class KayobeTestSpec extends PipelineSpockTestBase {

    def echo = {
        println("echoing: ${it}")
    }

    def sh = {
        println("running: ${it}")
    }

    def "test kayobe run"() {

        given:
        def steps = {
            echo "hello"
            sh "goodbye"
        }

        when:
        def script = loadScript('vars/kayobeRun.groovy')
        script.call(steps)

        then:
        printCallStack()
        assertJobStatusSuccess()
    }
}