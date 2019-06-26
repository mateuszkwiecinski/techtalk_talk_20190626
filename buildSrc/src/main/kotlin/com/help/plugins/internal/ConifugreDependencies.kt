package com.help.plugins.internal

import org.gradle.api.Project

internal fun Project.configureDependencies() = with(dependencies) {
    add("implementation", "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.40")
    add("implementation", "io.reactivex.rxjava2:rxjava:2.2.9")
    add("testImplementation", "junit:junit:4.12")
    add("testImplementation", "com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0")
    add("testImplementation", "org.mockito:mockito-core:2.28.2")
    add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.0-M1")
}
