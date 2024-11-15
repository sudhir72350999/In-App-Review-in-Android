plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.appreview"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.appreview"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // So, make sure you also include that repository in your project's build.gradle file.
    implementation ("com.google.android.play:review:2.0.1")

    // For Kotlin users also add the Kotlin extensions library for Play In-App Review:
    implementation ("com.google.android.play:review-ktx:2.0.1")
}