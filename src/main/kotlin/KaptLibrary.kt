/*
 * Copyright 2020 Thumbcat Software Solutions, LLC.
 * Use of this source code is governed by the Apache 2.0 license.
 * Original Author: https://github.com/icerockdev/mobile-multiplatform-gradle-plugin (Copyright 2019 IceRock MAG Inc.)
 */

import org.gradle.kotlin.dsl.DependencyHandlerScope

data class KaptLibrary(val name: String)

fun DependencyHandlerScope.kaptLibrary(kaptLibrary: KaptLibrary) {
    "kapt"(kaptLibrary.name)
}
