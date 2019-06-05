package com.help.plugins

import com.android.build.gradle.LibraryExtension
import com.help.plugins.internal.BaseAndroidPlugin
import org.gradle.api.Project

internal class AndroidLibraryPlugin : BaseAndroidPlugin() {

    override fun apply(project: Project) = with(project) {
        pluginManager.apply("com.android.library")
        super.apply(project)

        extensions.getByType(LibraryExtension::class.java).libraryVariants.all { variant ->
            variant.generateBuildConfigProvider.configure { it.enabled = false }
        }
    }
}
