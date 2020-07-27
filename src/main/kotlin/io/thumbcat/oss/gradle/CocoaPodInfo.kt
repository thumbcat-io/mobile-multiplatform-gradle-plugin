/*
 * Copyright 2020 Thumbcat Software Solutions, LLC.
 * Use of this source code is governed by the Apache 2.0 license.
 * Original Author: https://github.com/icerockdev/mobile-multiplatform-gradle-plugin (Copyright 2019 IceRock MAG Inc.)
 */

package io.thumbcat.oss.gradle

data class CocoaPodInfo(
    val scheme: String,
    val module: String,
    val onlyLink: Boolean
) {
    val capitalizedModule = module.capitalize()
}
