package com.help.plugins.internal

import com.android.build.gradle.TestedExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal abstract class BaseAndroidPlugin : Plugin<Project> {

    override fun apply(project: Project) = with(project) {
        pluginManager.apply("kotlin-android")
        with(repositories){
            google()
            jcenter()
        }

        extensions.getByType(TestedExtension::class.java).apply {
            compileSdkVersion(28)
            defaultConfig.apply {
                minSdkVersion(26)
                targetSdkVersion(28)
            }

            compileOptions.apply {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }
        }

        tasks.withType(KotlinCompile::class.java).all {
            it.kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }

}
