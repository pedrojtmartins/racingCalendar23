buildscript {
    dependencies {
        classpath(libs.google.services)
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0-beta02" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.dagger.hilt.android") version "2.45" apply false
    alias(libs.plugins.com.android.library) apply false
}

extra.apply {
    set("compileSdkVersion", 33)
    set("minSdkVersion", 24)
    set("targetSdkVersion", 33)
}
