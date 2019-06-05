package com.help.plugins.internal.base

import org.gradle.api.Project

internal fun Project.configureRepositories() = with(repositories) {
    google()
    jcenter()
    maven { repository ->
        repository.setUrl("https://jitpack.io")
        repository.mavenContent {
            it.includeGroupByRegex("com\\.github\\..*")
        }
    }
}
