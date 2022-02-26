object Config {

    object Sdk {
        const val minSdkVersion = 21
        const val targetSdkVersion = 31
        const val compileSdkVersion = 31
    }

    object Plugins {
        const val kotlin = "kotlin"
        const val javaLibrary = "java-library"
        const val androidApplication = "com.android.application"
        const val kotlinAndroid = "android"
        const val navigationSafArgs = "androidx.navigation.safeargs.kotlin"
        const val kotlinKapt = "kotlin-kapt"
        const val dagger = "dagger.hilt.android.plugin"
        const val androidLibrary = "com.android.library"
        const val ktLint = "org.jlleitschuh.gradle.ktlint"
        const val detekt = "io.gitlab.arturbosch.detekt"
        const val benManes = "com.github.ben-manes.versions"
    }

    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}
