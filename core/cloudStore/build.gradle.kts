plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.pjtm.racingcalendar23.core.cloudStore"
    compileSdk = rootProject.extra["compileSdkVersion"] as Int

    defaultConfig {
        minSdk = rootProject.extra["minSdkVersion"] as Int
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(libs.core.ktx)

    kapt(libs.hilt.compiler)
    implementation(libs.hilt)

    implementation("com.squareup.moshi:moshi-kotlin:1.14.0")

    implementation(libs.moshi)
    implementation(libs.firebase.storage.ktx)

    testImplementation(libs.junit)
}