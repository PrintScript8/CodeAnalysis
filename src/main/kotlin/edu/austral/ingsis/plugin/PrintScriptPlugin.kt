package edu.austral.ingsis.plugin

import kotlinx.kover.gradle.plugin.dsl.KoverProjectExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class PrintScriptPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        DetektPlugin().apply(target)
        SpotlessPlugin().apply(target)
        CheckStylePlugin().apply(target)
        KoverPlugin().apply(target)
    }
}