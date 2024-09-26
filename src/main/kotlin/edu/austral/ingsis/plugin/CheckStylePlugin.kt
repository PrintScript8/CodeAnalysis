package edu.austral.ingsis.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.quality.Checkstyle

class CheckStylePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("checkstyle")
//            configureCheckStyle()
        }
    }

//    private fun Project.configureCheckStyle() {
//        tasks.withType(Checkstyle::class.java).configureEach {
//            it.
//        }
//    }
}