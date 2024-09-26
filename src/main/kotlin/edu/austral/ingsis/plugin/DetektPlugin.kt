package edu.austral.ingsis.plugin

import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class DetektPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("io.gitlab.arturbosch.detekt")
            configureDetekt()
        }
    }

    private fun Project.configureDetekt() {
        extensions.configure(DetektExtension::class.java) {
            it.config.setFrom(files("config/detekt/detekt.yml")) // You can specify the YAML file location here
            it.buildUponDefaultConfig = true
        }

        tasks.named("detekt") {
            it.group = "verification"
            it.description = "Run detekt code analysis."
        }
    }
}