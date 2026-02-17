
import com.android.build.gradle.LibraryExtension

buildscript {
    repositories {
        mavenCentral()
        google()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.1.4")
    }
}

apply(plugin = "com.android.library")

// Project metadata
val bintrayRepo = "maven"
val bintrayName = "pdfium-android"

val publishedGroupId = "com.github.barteksc"
val libraryName = "PdfiumAndroid"
val artifact = "pdfium-android"

val libraryDescription = "Fork of library for rendering PDFs on Android's Surface or Bitmap"

val siteUrl = "https://github.com/barteksc/PdfiumAndroid"
val gitUrl = "https://github.com/barteksc/PdfiumAndroid.git"

val libraryVersion = "1.9.4"

val developerId = "barteksc"
val developerName = "Bartosz Schiller"
val developerEmail = "barteksch@boo.pl"

val licenseName = "The Apache Software License, Version 2.0"
val licenseUrl = "http://www.apache.org/licenses/LICENSE-2.0.txt"
val allLicenses = listOf("Apache-2.0")

configure<LibraryExtension> {
    namespace = "com.shockwave.pdfium"
    compileSdk = 34

    defaultConfig {
        minSdk = 26
    }
    
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }

    sourceSets {
        getByName("main") {
            // jni configuration is deprecated, NDK builds are handled by CMake
            jniLibs.srcDir("src/main/jni/lib")
        }
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    "implementation"(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    "implementation"("androidx.legacy:legacy-support-v4:1.0.0")
    "implementation"("com.jakewharton.timber:timber:5.0.1")
}

