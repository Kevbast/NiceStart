plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.nicestart"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.nicestart"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //para el swipe
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("com.airbnb.android:lottie:4.0.0")
    /*implementvideo
    implementation ("fileTree(dir: 'libs',include:['*.jar'])")
    implementation("com.android.support.constraint:constraint-layout-solver:2.0.4")
    //noinspection GradleCompatible
    implementation("com.android.support:appcompat-v7:28.0.0")
    //noinspection GradleCompatible
    implementation("com.android.support:recyclerview-v7:28.0.0")
    */
    implementation("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")
}