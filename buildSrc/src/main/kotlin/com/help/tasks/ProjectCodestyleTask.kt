package com.help.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.Project

open class ProjectCodestyleTask : DefaultTask() {

    init {
        group = "ci"
        description = "Runs all applied code style checks against the project"
    }

    companion object {
        const val TASK_NAME = "projectCodestyle"

        @JvmStatic
        fun applyToRootProject(project: Project) {
            project.rootProject.tasks.maybeCreate(TASK_NAME, ProjectCodestyleTask::class.java)
        }
    }
}
