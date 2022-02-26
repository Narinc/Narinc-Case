import dependencies.RemoteDep

plugins {
    id(Config.Plugins.javaLibrary)
    id(Config.Plugins.kotlin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    // Modules
    implementation(project(Modules.data))

    // Kotlin
    implementation(RemoteDep.kotlin)

    // JavaX
    implementation(RemoteDep.javax)

    // Network (Retrofit, Moshi)
    RemoteDep.retrofit.forEach { implementation(it) }

    // Network (OkHttp, Interceptor)
    implementation(platform(RemoteDep.okHttpBOM))
    RemoteDep.okHttp.forEach { implementation(it) }

    // Coroutines
    implementation(RemoteDep.coroutineCore)

    // Test Dependencies
    testImplementation(RemoteDep.Test.junit)
    testImplementation(RemoteDep.Test.assertJ)
    testImplementation(RemoteDep.Test.mockitoKotlin)
    testImplementation(RemoteDep.Test.mockitoInline)
    testImplementation(RemoteDep.Test.coroutines)
}
