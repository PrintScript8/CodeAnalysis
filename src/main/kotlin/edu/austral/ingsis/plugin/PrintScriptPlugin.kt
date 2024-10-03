package edu.austral.ingsis.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class PrintScriptPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        DetektPlugin().apply(target)
        SpotlessPlugin().apply(target)
        CustomCheckStylePlugin().apply(target)
        KoverPlugin().apply(target)
    }
}