package com.help.plugins.internal.base

import org.gradle.api.Project

internal fun Project.configureKapt() {
    pluginManager.apply("kotlin-kapt")
    extensions.configure(org.jetbrains.kotlin.gradle.plugin.KaptExtension::class.java) {
        it.correctErrorTypes = true
        it.useBuildCache = true
        it.arguments {
            arg("dagger.formatGeneratedSource", "disabled")
            arg("dagger.gradle.incremental")
        }
    }
}
