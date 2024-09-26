package edu.austral.ingsis.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import io.gitlab.arturbosch.detekt.extensions.DetektExtension

class KoverPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.tasks.register("kover") {
            with(target) {
                pluginManager.apply("org.jetbrains.kotlinx")
                configureKover()
            }
        }
    }

    private fun Project.configureKover() {
        extensions.configure(DetektExtension::class.java) {
            it.buildUponDefaultConfig = true
            it.config = files("${project.rootDir}/config/kover-config.yml") // Adjust to your config files as needed
        }
    }
}