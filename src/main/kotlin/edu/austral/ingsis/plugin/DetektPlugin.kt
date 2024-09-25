package edu.austral.ingsis.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import io.gitlab.arturbosch.detekt.extensions.DetektExtension

class DetektPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("io.gitlab.arturbosch.detekt")
            configureDetekt()
        }
    }

    private fun Project.configureDetekt() {
        extensions.configure(DetektExtension::class.java) {
            it.toolVersion = "1.18.1"
            it.config = files().from(
                """
                autoCorrect: true
                buildUponDefaultConfig: true
                config:
                  - active: true
                    autoCorrect: true
                    maxIssues: 10
                """.trimIndent()
            )
        }
    }
}