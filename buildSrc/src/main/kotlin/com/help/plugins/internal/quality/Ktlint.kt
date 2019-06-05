package com.help.plugins.internal.quality

import com.help.tasks.ProjectCodestyleTask
import org.gradle.api.Project
import org.jmailen.gradle.kotlinter.KotlinterExtension
import org.jmailen.gradle.kotlinter.KotlinterPlugin
import org.jmailen.gradle.kotlinter.tasks.LintTask

internal fun Project.configureKtlint() {
    afterEvaluate {
        pluginManager.apply(KotlinterPlugin::class.java)
        extensions.configure(KotlinterExtension::class.java) {
            it.indentSize = 4
            it.continuationIndentSize = 4
            it.reporters = arrayOf("plain")
            it.allowWildcardImports = false
            it.experimentalRules = false // TODO enable?
        }
    }
    tasks.withType(LintTask::class.java) {
        rootProject.tasks.named(ProjectCodestyleTask.TASK_NAME) { projectCodestyle ->
            projectCodestyle.dependsOn(it)
        }
    }
}
