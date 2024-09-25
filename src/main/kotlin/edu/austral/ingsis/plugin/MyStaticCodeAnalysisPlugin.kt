package edu.austral.ingsis.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction

class MyStaticCodeAnalysisPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // Apply the conventions from the gradle files
        project.apply(mapOf("from" to "edu/austral/ingsis/plugin/main/resources/conventions/application-conventions.gradle"))
        project.apply(mapOf("from" to "edu/austral/ingsis/plugin/main/resources/conventions/common-conventions.gradle"))

        // Register the static analysis task
        project.tasks.register("runStaticAnalysis", StaticAnalysisTask::class.java)
    }
}

abstract class StaticAnalysisTask : org.gradle.api.DefaultTask() {
    @TaskAction
    fun runAnalysis() {
        println("Running static code analysis...")
        // Integrate static code analysis logic here
    }
}