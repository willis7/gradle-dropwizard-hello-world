package com.github.willis.buildsrc.ssh

import org.gradle.api.DefaultTask
import org.gradle.api.file.FileCollection
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.TaskAction

/**
 * @author Sion Williams
 */
class Scp extends DefaultTask {
    @InputFiles
    FileCollection classpath

    @Input
    String host

    @Input
    String username

    @Input
    String password

    @InputFile
    File sourceFile

    @Input
    String destination

    @Input
    Integer port

    @TaskAction
    void runCommand() {
        logger.quiet("Copying file $sourceFile to $host")
        ant.taskdef(name: 'jschScp', classname: 'org.apache.tools.ant.taskdefs.optional.ssh.Scp', classpath: classpath.asPath)
        ant.jschScp(file: sourceFile,
                todir: "${username}:${password}@${host}:${destination}",
                port: port,
                trust: true)
    }

}
