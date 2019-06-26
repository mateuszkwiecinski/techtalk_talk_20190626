package com.help.plugins

import com.help.plugins.internal.configureDependencies
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class KotlinLibraryPlugin : Plugin<Project> {

    override fun apply(project: Project) = with(project) {
        pluginManager.apply("kotlin")
        with(repositories) {
            google()
            jcenter()
        }
        configureDependencies()

        tasks.withType(KotlinCompile::class.java).all {
            it.kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}
