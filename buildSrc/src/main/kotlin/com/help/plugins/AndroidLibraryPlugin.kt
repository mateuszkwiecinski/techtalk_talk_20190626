package com.help.plugins

import com.help.plugins.internal.BaseAndroidPlugin
import org.gradle.api.Project

internal class AndroidLibraryPlugin : BaseAndroidPlugin() {

    override fun apply(project: Project) {
        project.pluginManager.apply("com.android.library")
        super.apply(project)
    }
}
