plugins {
    id("david.android.library")
    id("david.android.hilt")
}

android {
    namespace = "com.david.lifetoolbox.core.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
}