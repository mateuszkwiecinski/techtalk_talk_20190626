package com.help.plugins.internal

import com.help.plugins.internal.quality.configureKtlint
import com.help.tasks.ProjectCodestyleTask
import com.help.plugins.internal.quality.configureDetekt
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class QualityPlugin : Plugin<Project> {

    override fun apply(project: Project) = with(project) {
        ProjectCodestyleTask.applyToRootProject(this)

        configureDetekt()
        configureKtlint()
    }
}
