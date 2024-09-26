package edu.austral.ingsis.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.quality.CheckstyleExtension
import java.io.File

class CheckStylePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("checkstyle")
            configureCheckStyle()
        }
    }

    private fun Project.configureCheckStyle() {
        val checkStyleConfigFile = File("${project.rootDir}/config/checkstyle.xml")
        extensions.configure(CheckstyleExtension::class.java) {
            it.config = resources.text.fromFile(checkStyleConfigFile)
        }
    }
}