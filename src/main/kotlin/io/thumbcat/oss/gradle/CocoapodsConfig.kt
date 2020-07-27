/*
 * Copyright 2020 Thumbcat Software Solutions, LLC.
 * Use of this source code is governed by the Apache 2.0 license.
 * Original Author: https://github.com/icerockdev/mobile-multiplatform-gradle-plugin (Copyright 2019 IceRock MAG Inc.)
 */

package io.thumbcat.oss.gradle

import java.io.File

open class CocoapodsConfig {
    lateinit var podsProject: File
    var buildConfiguration: String = "debug"

    private val _dependencies = mutableListOf<CocoaPodInfo>()
    val dependencies: List<CocoaPodInfo> = _dependencies

    fun pod(name: String, onlyLink: Boolean = false) {
        pod(scheme = name, module = name, onlyLink = onlyLink)
    }

    fun pod(scheme: String, module: String, onlyLink: Boolean = false) {
        _dependencies.add(
            CocoaPodInfo(
                scheme = scheme,
                module = module,
                onlyLink = onlyLink
            )
        )
    }
}
