// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.3" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1" apply false
}

//Adding based on tutorial (https://developers.google.com/maps/documentation/android-sdk/start)
// Note: Instructions say to use "project-level" build.gradle but this appears to (possibly) be a mistake.
// I kept running into errors and resolved it by moving this secret section to "module level" build.gradle
buildscript {
    dependencies {
        classpath("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
    }
}

