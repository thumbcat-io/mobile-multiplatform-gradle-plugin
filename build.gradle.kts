/*
 * Copyright 2020 Thumbcat Software Solutions, LLC.
 * Use of this source code is governed by the Apache 2.0 license.
 * Original Author: https://github.com/icerockdev/mobile-multiplatform-gradle-plugin (Copyright 2019 IceRock MAG Inc.)
 */

plugins {
    `kotlin-dsl`
    `maven-publish`
    id("org.jmailen.kotlinter")
}

repositories {
    jcenter()
    google()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compileOnly("com.android.tools.build:gradle:4.0.1")
    compileOnly("org.jetbrains.kotlin:kotlin-compiler-embeddable:1.3.72")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

val pluginName = "mobile-multiplatform"

publishing {
    publications {
        create<MavenPublication>("pluginMaven") {
            artifactId = pluginName
        }
        create<MavenPublication>("mobileMultiplatformPluginMarkerMaven") {
            groupId = "$group.$pluginName"
            artifactId = "$group.$pluginName.gradle.plugin"
            pom {
                withXml {
                    asNode().appendNode("dependencies").let { depNode ->
                        depNode.appendNode("dependency").apply {
                            appendNode("groupId", group.toString())
                            appendNode("artifactId", pluginName)
                            appendNode("version", project.version.toString())
                        }
                    }
                }
            }
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xskip-metadata-version-check")
    }
}
