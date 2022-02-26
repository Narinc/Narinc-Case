plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

object Plugins {
    const val AGP = "7.0.4"
    const val KOTLIN = "1.6.10"
    const val HILT = "2.40.5"
    const val NAVIGATION = "2.3.5"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${Plugins.KOTLIN}")
    implementation("com.android.tools.build:gradle:${Plugins.AGP}")
    implementation("com.google.dagger:hilt-android-gradle-plugin:${Plugins.HILT}")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:${Plugins.NAVIGATION}")
}
