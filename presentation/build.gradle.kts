import dependencies.PresentationDep

version = PresenterEnvironments.LIBRARY_VERSION

plugins {
    id(Config.Plugins.androidLibrary)
    kotlin(Config.Plugins.kotlinAndroid)
    id(Config.Plugins.kotlinKapt)
}

android {
    compileSdk = Config.Sdk.compileSdkVersion

    defaultConfig {
        minSdk = Config.Sdk.minSdkVersion
        targetSdk = Config.Sdk.targetSdkVersion

        testInstrumentationRunner = Config.testRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    lint {
        isWarningsAsErrors = true
        isAbortOnError = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(Modules.domain))

    implementation(PresentationDep.kotlin)
    implementation(PresentationDep.coroutineCore)
    // Dagger-Hilt (used for @InjectViewModel)
    PresentationDep.daggerHilt.forEach {
        implementation(it)
    }
    PresentationDep.daggerHiltKapt.forEach {
        kapt(it)
    }
    // JavaX
    implementation(PresentationDep.javax)
    // LifeCycle
    PresentationDep.lifeCycle.forEach {
        implementation(it)
    }

    // Test Dependencies
    testImplementation(PresentationDep.Test.junit)
    testImplementation(PresentationDep.Test.assertJ)
    testImplementation(PresentationDep.Test.mockitoKotlin)
    testImplementation(PresentationDep.Test.mockitoInline)
    testImplementation(PresentationDep.Test.coroutines)
    testImplementation(PresentationDep.Test.androidxArchCore)
    testImplementation(PresentationDep.Test.robolectric)
    testImplementation(PresentationDep.Test.testExtJunit)
}
