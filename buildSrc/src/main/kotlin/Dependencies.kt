object Versions {
    val kotlin = "1.4.20"
    val gradle = "4.1.2"

    val compile_sdk = 30
    val build_tool = "30.0.3"
    val min_sdk = 21
    val target_sdk = 30

    val support = "1.0.2"

    val junit = "4.+"
}

object Libraries {
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val core_ktx = "androidx.core:core-ktx:1.3.2"
    val google_material = "com.google.android.material:material:1.3.0"
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