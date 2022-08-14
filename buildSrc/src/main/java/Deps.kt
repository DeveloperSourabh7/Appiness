object Versions {
    val coreKtx_v = "1.7.0"
    val appCompat_v = "1.4.2"
    val LifeCycleRuntimeKtx_v = "2.3.1"
    val ActivityCompose_v = "1.3.1"
    val ConstraintLayout_v = "2.1.4"
    val Fragment_v = "1.4.1"
    val JUnit_v = "4.13.2"
    val TestExtJunit_v = "1.1.3"
    val Espresso_v = "3.4.0"
    val accompanistPager_v = "0.18.0"
    val material_v = "1.6.1"
    val loginInterceptor_v = "4.7.2"
    val retrofit_v = "2.9.0"
    val gsonConvertor_v = "2.5.0"
    val mockk_version = "1.12.1"
}

object AndroidX {
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx_v}"
    val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat_v}"
    val LifeCycleRuntimeKtx =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LifeCycleRuntimeKtx_v}"
    val ActivityCompose =
        "androidx.activity:activity-compose:${Versions.ActivityCompose_v}"
    val ConstraintLayout: String =
        "androidx.constraintlayout:constraintlayout:${Versions.ConstraintLayout_v}"

    //For viewModels
    val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LifeCycleRuntimeKtx_v}"
    val runtimeLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LifeCycleRuntimeKtx_v}"
    val fragment="androidx.fragment:fragment-ktx:${Versions.Fragment_v}"

    //For Retrofit and okhttp
    val GsonConvertor: String =
        "com.squareup.retrofit2:converter-gson:${Versions.gsonConvertor_v}"
    val Retrofit2: String =
        "com.squareup.retrofit2:retrofit:${Versions.retrofit_v}"
    val LoggingInterceptor: String =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loginInterceptor_v}"
    val okHttp3: String =
        "com.squareup.okhttp3:okhttp:${Versions.loginInterceptor_v}"
    val adapterRetrofit = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
}

object Material {
    val material = "com.google.android.material:material:${Versions.material_v}"
}

object Testing {
    val JUnit = "junit:junit:${Versions.JUnit_v}"
    val TestExtJunit = "androidx.test.ext:junit:${Versions.TestExtJunit_v}"
    val Espresso = "androidx.test.espresso:espresso-core:${Versions.Espresso_v}"
}

object Mocck{
    val mocck = "io.mockk:mockk:${Versions.mockk_version}"
    val mocck_android = "io.mockk:mockk-android:${Versions.mockk_version}"
}

object Google {
    val accompanistPager =
        "com.google.accompanist:accompanist-pager:${Versions.accompanistPager_v}"
}