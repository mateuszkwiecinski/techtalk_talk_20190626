package com.help.plugins.internal.quality

import com.help.tasks.ProjectCodestyleTask
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektPlugin
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Project

internal fun Project.configureDetekt() {
    pluginManager.apply(DetektPlugin::class.java)

    extensions.configure(DetektExtension::class.java) {
        it.reports.html {
            enabled = false
        }
        it.reports.xml {
            enabled = false
        }
        it.config.setFrom(rootProject.file("buildSrc/build/resources/main/detekt.yml"))
        val baseline = file("detekt-baseline.xml")
        // Command for refreshing baselines:
        // rm **/detekt-baseline.xml ; ./gradlew detektBaseline -PrefreshBaseline --continue
        if (baseline.exists() || hasProperty("refreshBaseline")) {
            it.baseline = baseline
        }
    }
    tasks.named("detekt", Detekt::class.java) {
        it.exclude(".*/resources/.*", ".*/build/.*")
    }
    rootProject.tasks.named(ProjectCodestyleTask.TASK_NAME) {
        it.dependsOn("$path:detekt")
    }
}
