/*
 * Copyright 2020 Thumbcat Software Solutions, LLC.
 * Use of this source code is governed by the Apache 2.0 license.
 * Original Author: https://github.com/icerockdev/mobile-multiplatform-gradle-plugin (Copyright 2019 IceRock MAG Inc.)
 */

import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project
import org.jetbrains.kotlin.gradle.plugin.mpp.Framework

data class MultiPlatformModule(
    val name: String,
    val exported: Boolean = false
) : KotlinNativeExportable {

    override fun export(project: Project, framework: Framework) {
        if (!exported) return

        framework.export(project.project(name))
    }
}

fun DependencyHandlerScope.mppModule(module: MultiPlatformModule) {
    val name = module.name
    "androidMainImplementation"(dependencies.project(path = name))
    "commonMainApi"(dependencies.project(path = name))
    "iosX64MainImplementation"(dependencies.project(path = name))
    "iosArm64MainImplementation"(dependencies.project(path = name))
}
