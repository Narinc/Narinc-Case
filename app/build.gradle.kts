import dependencies.UiDep

plugins {
    id(Config.Plugins.androidApplication)
    kotlin(Config.Plugins.kotlinAndroid)
    id(Config.Plugins.kotlinKapt)
    id(Config.Plugins.dagger)
    id(Config.Plugins.navigationSafArgs)
}

android {
    compileSdk = Config.Sdk.compileSdkVersion

    defaultConfig {
        applicationId = appId
        minSdk = Config.Sdk.minSdkVersion
        targetSdk = Config.Sdk.targetSdkVersion

        testInstrumentationRunner = Config.testRunner
    }

    buildTypes {
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("debug") {
            isTestCoverageEnabled = true
        }

        create("uat") {
            initWith(getByName("release"))
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        viewBinding = true
    }

    lint {
        isWarningsAsErrors = true
        isAbortOnError = true
    }

    flavorDimensions.add("server")
    productFlavors {
        create("dev") {
            dimension = "server"
            applicationIdSuffix = ".dev"
            versionCode = DevelopmentEnvironments.versionCode
            versionName = DevelopmentEnvironments.versionName

            buildConfigField("String", "BASE_URL", "\"" + DevelopmentEnvironments.baseUrl + "\"")
        }
        create("prod") {
            dimension = "server"
            applicationIdSuffix = ".prod"
            versionCode = ProductionEnvironments.versionCode
            versionName = ProductionEnvironments.versionName

            buildConfigField("String", "BASE_URL", "\"" + ProductionEnvironments.baseUrl + "\"")
        }
    }
}

dependencies {

    // Modules
    implementation(project(Modules.domain))
    implementation(project(Modules.data))
    implementation(project(Modules.remote))
    implementation(project(Modules.cache))
    implementation(project(Modules.presentation))

    // Core Dependencies
    implementation(kotlin("stdlib", Versions.kotlinVersion))
    implementation(UiDep.coreKtx)
    implementation(UiDep.appCompat)
    implementation(UiDep.material)
    implementation(UiDep.constraint)
    implementation(UiDep.navigationFragmentKtx)
    implementation(UiDep.navigationUiKtx)
    implementation(UiDep.activityKtx)

    // LifeCycle
    UiDep.LifeCycle.forEach {
        implementation(it)
    }

    // Dagger-Hilt
    UiDep.DaggerHilt.forEach {
        implementation(it)
    }
    UiDep.DaggerHiltKapt.forEach {
        kapt(it)
    }

    // Coroutines
    UiDep.Coroutines.forEach {
        implementation(it)
    }

    // Glide
    implementation(UiDep.glide)
    kapt(UiDep.glideKapt)

    // Timber
    implementation(UiDep.timber)

    // Lottie animation
    implementation(UiDep.lottie)

    // Test Dependencies
    testImplementation(UiDep.Test.junit)
    testImplementation(UiDep.Test.assertJ)
    testImplementation(UiDep.Test.mockitoKotlin)
    testImplementation(UiDep.Test.mockitoInline)
    testImplementation(UiDep.Test.coroutines)
    testImplementation(UiDep.Test.androidxArchCore)
    testImplementation(UiDep.Test.robolectric)
    testImplementation(UiDep.Test.testExtJunit)
}
