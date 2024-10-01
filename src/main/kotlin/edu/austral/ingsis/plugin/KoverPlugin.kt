package edu.austral.ingsis.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import kotlinx.kover.gradle.plugin.dsl.KoverProjectExtension
import kotlinx.kover.gradle.plugin.dsl.CoverageUnit

class KoverPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jetbrains.kotlinx.kover")
            configureKover()
        }
    }

    private fun Project.configureKover() {
        extensions.configure(KoverProjectExtension::class.java) { kover ->
            kover.reports {
                it.verify {
                    it.rule {
                        it.minBound(80, CoverageUnit.LINE)
                    }
                }
            }
        }

    }
}