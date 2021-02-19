object Versions {
    val kotlin = "1.4.20"
    val gradle = "4.1.2"

    val compile_sdk = 30
    val build_tool = "30.0.3"
    val min_sdk = 21
    val target_sdk = 30

    val support = "1.0.2"

    val junit = "4.+"

    val dagger = "2.24"
}

object Libraries {
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val core_ktx = "androidx.core:core-ktx:1.3.2"
    val google_material = "com.google.android.material:material:1.3.0"

    val dagger_android = "com.google.dagger:dagger-android:${Versions.dagger}"
    val dagger_android_support = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val dagger_android_processor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
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