plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlinx-serialization")
    id ("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.dokka") version "1.9.20"

}

android {
    namespace = "com.tv.weatherapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.tv.weatherapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //mock
    testImplementation ("io.mockk:mockk:1.13.5")

    // coroutines
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")

    //flows
    testImplementation( "app.cash.turbine:turbine:1.0.0")

    kaptTest ("com.google.dagger:hilt-android-compiler:2.51.1")

    testImplementation ("com.google.dagger:hilt-android-testing:2.51.1")

    androidTestImplementation( "com.google.dagger:hilt-android-testing:2.51")
    kaptAndroidTest ("com.google.dagger:hilt-compiler:2.51")

    testImplementation( "com.google.truth:truth:1.4.4")



    implementation(libs.kotlin.serialization.json)

    //Dagger - Hilt
    implementation(libs.dagger.hilt.android)
    kapt(libs.dagger.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    implementation(libs.androidx.navigation.compose)


    // Retrofit
    implementation (libs.retrofit.core)
    implementation (libs.retrofit.moshi.converter)
    implementation (libs.okhttp.logging.interceptor)

    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)

    // room db
    implementation(libs.room.ktx)
    implementation(libs.room.runtime)

    implementation(libs.lifecycle.viewmodel.compose)

    implementation(libs.coil.compose)
    implementation(libs.datastore.preferences)


}