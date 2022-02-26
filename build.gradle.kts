plugins {
    id(Config.Plugins.androidApplication) apply false
    id(Config.Plugins.androidLibrary) apply false
    kotlin(Config.Plugins.kotlinAndroid) apply false
    id(Config.Plugins.ktLint) version (Versions.ktLintVersion)
    id(Config.Plugins.detekt) version (Versions.detektVersion)
    id(Config.Plugins.benManes) version (Versions.benManesVersion)
}

apply(from = "gradle/jacoco.gradle")

allprojects {
    group = appId
    repositories {
        google()
        mavenCentral()
    }
}

subprojects {
    apply {
        plugin(Config.Plugins.ktLint)
        plugin(Config.Plugins.detekt)
        plugin(Config.Plugins.benManes)
    }

    ktlint {
        debug.set(true)
        version.set(Versions.ktLintSnapshotVersion)
        verbose.set(true)
        android.set(false)
        outputToConsole.set(true)
        ignoreFailures.set(false)
        enableExperimentalRules.set(true)
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }

    detekt {
        config = rootProject.files("config/detekt/detekt.yml")
        tasks.detekt {
            reports {
                html {
                    outputLocation.set(file("build/reports/detekt.html"))
                    required.set(true) // reports can also be enabled and disabled at the task level as needed
                }
            }
        }
    }
}

tasks {
    register("clean", Delete::class.java) {
        delete(rootProject.buildDir)
    }

    withType<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask> {
        rejectVersionIf {
            candidate.version.isStableVersion().not()
        }
    }
}
