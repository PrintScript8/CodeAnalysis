package edu.austral.ingsis.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class PrintScriptPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        CheckStylePlugin().apply(target)
        SpotlessPlugin().apply(target)
        DetektPlugin().apply(target)
    }
}