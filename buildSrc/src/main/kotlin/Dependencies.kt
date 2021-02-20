import org.gradle.api.JavaVersion

object Modules {
    val domain = ":domain"
    val data = ":data"
    val presentation = ":presentation"
    val remote = ":remote"
}

object Versions {
    val kotlin = "1.4.20"
    val gradle = "4.1.2"

    val compile_sdk = 30
    val build_tool = "30.0.3"
    val min_sdk = 21
    val target_sdk = 30

    val support = "1.2.0"

    val junit = "4.+"

    val dagger = "2.24"

    val lifecycle = "2.2.0"

    val okhttp = "3.10.0"
    val retrofit = "2.6.2"

    val rx_android = "2.0.2"
    val rx_kotlin = "2.2.0"

    val inject = "1"

    val jvmTarget = "1.8"
    val javaSourceCompatibility = JavaVersion.VERSION_1_8
    val javaTargetCompatibility = JavaVersion.VERSION_1_8

}

object Libraries {
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val core_ktx = "androidx.core:core-ktx:1.3.2"
    val google_material = "com.google.android.material:material:1.3.0"

    val dagger_android = "com.google.dagger:dagger-android:${Versions.dagger}"
    val dagger_android_support = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val dagger_android_processor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    val constraint_layout = "androidx.constraintlayout:constraintlayout:2.0.4"

    val lifecycle_extension = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"

    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    val okhttp_logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val retrofitRxJava = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"

    val rx_android = "io.reactivex.rxjava2:rxandroid:${Versions.rx_android}"
    val rx_kotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rx_kotlin}"

    val inject = "javax.inject:javax.inject:${Versions.inject}"
}

object SupportLibraries {
    val appcompat = "androidx.appcompat:appcompat:${Versions.support}"
}

object TestLibraries {
    val junit = "junit:junit:${Versions.junit}"
}

object AndroidTestLibraries {
    val junit = "androidx.test.ext:junit:1.1.2"
    val espresso = "androidx.test.espresso:espresso-core:3.3.0"
}