package edu.austral.ingsis.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.diffplug.gradle.spotless.SpotlessExtension

class SpotlessPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.diffplug.spotless")
            configureSpotless()
        }
    }

    private fun Project.configureSpotless() {
        extensions.configure(SpotlessExtension::class.java) {
            it.kotlin {
                it.ktlint()
            }
        }
    }
}