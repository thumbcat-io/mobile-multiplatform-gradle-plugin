/*
 * Copyright 2020 Thumbcat Software Solutions, LLC.
 * Use of this source code is governed by the Apache 2.0 license.
 * Original Author: https://github.com/icerockdev/mobile-multiplatform-gradle-plugin (Copyright 2019 IceRock MAG Inc.)
 */

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

fun Project.setupFramework(
    exports: List<KotlinNativeExportable>,
    name: String = "MultiPlatformLibrary"
) {
    val configureIos: KotlinNativeTarget.() -> Unit = {
        binaries {
            framework(name) {
                freeCompilerArgs = freeCompilerArgs + "-Xobjc-generics"

                exports.forEach { it.export(project, this) }
            }
        }
    }

    extensions.findByType(KotlinMultiplatformExtension::class.java)?.run {
        ios(configure = configureIos)
    }
}
