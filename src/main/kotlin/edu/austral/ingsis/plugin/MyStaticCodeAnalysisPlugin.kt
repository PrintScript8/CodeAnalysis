package edu.austral.ingsis.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction

class MyStaticCodeAnalysisPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // Load the convention files from the plugin's resources
        val applicationConventions = MyStaticCodeAnalysisPlugin::class.java
            .getResource("/conventions/application-conventions.gradle")
        val commonConventions = MyStaticCodeAnalysisPlugin::class.java
            .getResource("/conventions/common-conventions.gradle")

        // Apply the convention files to the project
        if (applicationConventions != null && commonConventions != null) {
            project.apply(mapOf("from" to applicationConventions))
            project.apply(mapOf("from" to commonConventions))
        } else {
            throw IllegalStateException("Could not load convention files.")
        }

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