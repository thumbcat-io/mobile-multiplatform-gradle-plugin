pluginManagement {
    @Suppress("UnstableApiUsage")
    plugins {
        id("org.jmailen.kotlinter") version "2.4.1"
    }
    repositories {
        jcenter()
        gradlePluginPortal()
    }
}

rootProject.name = "mobile-multiplatform-gradle-plugin"
