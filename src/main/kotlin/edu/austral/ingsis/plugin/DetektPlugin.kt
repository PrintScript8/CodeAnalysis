package edu.austral.ingsis.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import java.io.File

class DetektPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("io.gitlab.arturbosch.detekt")
            configureDetekt()
        }
    }

    private fun Project.configureDetekt() {
        // Specify the path to your detekt-config.yml file
        val detektConfigFile = File("${project.rootDir}/config/detekt-config.yml")

        extensions.configure(DetektExtension::class.java) {
            it.config = files(detektConfigFile) // Use the created config file
        }
    }
}