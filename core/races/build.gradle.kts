plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.pjtm.racingcalendar23.core.races"
    compileSdk = rootProject.extra["compileSdkVersion"] as Int

    defaultConfig {
        minSdk = rootProject.extra["minSdkVersion"] as Int
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
        isCoreLibraryDesugaringEnabled = true
    }
}

dependencies {
    coreLibraryDesugaring(libs.desugar.jdk.libs)

    implementation(project(":core:database"))
    implementation(project(":core:cloudStore"))

    implementation(libs.core.ktx)
    implementation(project(mapOf("path" to ":core:common")))

    kapt(libs.hilt.compiler)
    implementation(libs.hilt)

    testImplementation(libs.junit)
}