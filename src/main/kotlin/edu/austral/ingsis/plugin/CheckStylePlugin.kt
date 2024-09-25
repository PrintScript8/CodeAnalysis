package edu.austral.ingsis.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.quality.CheckstyleExtension

class CheckStylePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("checkstyle")
            configureCheckStyle()
        }
    }

    private fun Project.configureCheckStyle() {
        extensions.configure(CheckstyleExtension::class.java) {
            it.toolVersion = "8.44"
            it.config = resources.text.fromFile("checkstyle.xml")
        }
    }
}