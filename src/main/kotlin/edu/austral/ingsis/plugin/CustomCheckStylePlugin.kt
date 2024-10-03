package edu.austral.ingsis.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.quality.Checkstyle
import org.gradle.api.plugins.quality.CheckstyleExtension
import org.gradle.api.tasks.SourceSetContainer
import java.io.File
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.StandardCopyOption

class CustomCheckStylePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("checkstyle")
        }

        // Configure the Checkstyle extension
        val checkstyle = target.extensions.getByType(CheckstyleExtension::class.java)
        checkstyle.toolVersion = "10.17.0"

        // Load the rules.xml from the classpath
        val rulesConfigStream: InputStream? = javaClass.classLoader.getResourceAsStream("checkstyle.xml")
        if (rulesConfigStream != null) {
            val tempRulesFile = File.createTempFile("checkstyle", ".xml").apply {
                deleteOnExit()
            }
            Files.copy(rulesConfigStream, tempRulesFile.toPath(), StandardCopyOption.REPLACE_EXISTING)
            checkstyle.configFile = tempRulesFile
        } else {
            throw IllegalStateException("Could not find checkstyle.xml in the classpath")
        }

        // Configure Checkstyle tasks for each source set
        val sourceSets = target.extensions.getByType(SourceSetContainer::class.java)
        sourceSets.all { sourceSet ->
            val taskName = "checkstyle${capitalize(sourceSet.name)}"
            target.tasks.named(taskName, Checkstyle::class.java) { task ->
                task.source = sourceSet.allSource
                task.reports.html.outputLocation.set(target.file("${target.rootDir}/reports/checkstyle/${target.name}-${sourceSet.name}.html"))
            }
        }
    }

    private fun capitalize(str: String): String {
        return if (str.isEmpty()) {
            str
        } else {
            str[0].uppercaseChar() + str.substring(1)
        }
    }
}