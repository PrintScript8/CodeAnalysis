package edu.austral.ingsis.plugin

import kotlinx.kover.gradle.plugin.dsl.KoverProjectExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class KoverPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jetbrains.kotlinx.kover")
            configureKover()
        }
    }

    private fun Project.configureKover() {
        extensions.configure(KoverProjectExtension::class.java) {
            it.useJacoco()  // Use JaCoCo as the coverage tool
        }
    }
}