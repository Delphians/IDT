import org.jetbrains.kotlin.gradle.plugin.KaptExtension

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    kotlin("plugin.serialization") version "2.0.21"
}

android {
    namespace = "com.che.idt.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 26
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_21.toString()
    }
}

extensions.configure(KaptExtension::class.java) {
    correctErrorTypes = true

    javacOptions {
        option("-Adagger.hilt.disableModulesHaveInstallInCheck=true")
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(libs.dagger.core)
    implementation(libs.dagger.runtime)
    kapt(libs.dagger.compiler)

    implementation(libs.kotlinx.serialization)

    testImplementation(libs.coroutines.test)
    testImplementation(libs.mockk)
    testImplementation(kotlin("test"))
}

