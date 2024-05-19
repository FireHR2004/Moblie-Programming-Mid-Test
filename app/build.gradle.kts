plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.androidappstest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androidappstest"
        minSdk = 34
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

    buildFeatures{
        viewBinding = true
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
//    implementation ("com.github.VishnuSivadasVS:Advanced-HttpURLConnection:1.2")
//    implementation("com.android.volley:volley-cronet:1.2.1")
    implementation("com.android.volley:volley:1.2.1")
    implementation(libs.constraintlayout)
    implementation(libs.google.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation ("com.squareup.picasso:picasso:2.71828")
}