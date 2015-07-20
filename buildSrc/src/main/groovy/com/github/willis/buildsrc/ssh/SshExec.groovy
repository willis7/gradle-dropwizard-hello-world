package com.github.willis.buildsrc.ssh

import org.gradle.api.DefaultTask
import org.gradle.api.file.FileCollection
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction

/**
 * @author Sion Williams
 */
class SshExec extends DefaultTask {
    @InputFiles
    FileCollection classpath

    @Input
    String host

    @Input
    String username

    @Input
    String password

    @Input
    String command

    @Input
    Integer port

    @Optional
    String outputDir = "${project.buildDir}/sshexec/"

    @Input
    String output = "result.txt"

    @Input
    Boolean failonerror = true

    @TaskAction
    void runCommand() {
        project.file(outputDir).mkdirs()
        ant.taskdef( name: 'sshexec', classname: 'org.apache.tools.ant.taskdefs.optional.ssh.SSHExec', classpath: classpath.asPath )
        ant.sshexec( host: host,
                        username: username,
                        password: password,
                        command: command,
                        port: port,
                        trust: true,
                        output: outputDir + output,
                        outputproperty: "output_log",
                        failonerror: failonerror)
    }
}
