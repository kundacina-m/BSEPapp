import kotlin.String

/**
 * Find which updates are available by running
 *     `$ ./gradlew buildSrcVersions`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version.
 */
object Versions {
    const val appcompat: String = "1.0.2" // available: "1.1.0"

    const val core_testing: String = "2.0.0" // available: "2.1.0"

    const val cardview: String = "1.0.0" 

    const val constraintlayout: String = "1.1.3" 

    const val core_ktx: String = "1.0.2" // available: "1.3.0"

    const val androidx_databinding: String = "3.5.0" // available: "4.0.0"

    const val lifecycle_extensions: String = "2.0.0" // available: "2.2.0"

    const val navigation_fragment_ktx: String = "2.0.0" // available: "2.3.0"

    const val navigation_runtime_ktx: String = "2.0.0" // available: "2.3.0"

    const val navigation_safe_args_gradle_plugin: String = "2.1.0-alpha05" // available: "2.3.0"

    const val navigation_ui_ktx: String = "2.0.0" // available: "2.3.0"

    const val paging_runtime: String = "2.1.0" // available: "2.1.2"

    const val recyclerview: String = "1.0.0" // available: "1.1.0"

    const val androidx_room: String = "2.1.0" // available: "2.2.5"

    const val espresso_core: String = "3.2.0" 

    const val androidx_test: String = "1.2.0" 

    const val aapt2: String = "3.5.0-5435860" // available: "4.0.0-6051327"

    const val com_android_tools_build_gradle: String = "3.4.1" // available: "4.0.0"

    const val lint_gradle: String = "26.5.0" // available: "27.0.0"

    const val stetho: String = "1.5.0" // available: "1.5.1"

    const val timberkt: String = "1.5.1" 

    const val com_github_bumptech_glide: String = "4.9.0" // available: "4.11.0"

    const val auto_value_annotations: String = "1.6.3" // available: "1.7.3"

    const val auto_value: String = "1.6.5" // available: "1.7.3"

    const val com_google_dagger: String = "2.22.1" // available: "2.28.1"

    const val google_services: String = "4.3.0" // available: "4.3.3"

    const val com_squareup_moshi: String = "1.8.0" // available: "1.9.3"

    const val logging_interceptor: String = "4.2.0" // available: "4.7.2"

    const val okhttp_tls: String = "4.7.2" 

    const val okhttp: String = "4.2.0" // available: "4.7.2"

    const val adapter_rxjava2: String = "2.6.0" // available: "2.9.0"

    const val converter_gson: String = "2.9.0" // available: "2.9.0"

    const val converter_moshi: String = "2.6.0" // available: "2.9.0"

    const val retrofit: String = "2.6.0" // available: "2.9.0"

    const val de_fayard_buildsrcversions_gradle_plugin: String = "0.3.2" // available: "0.7.0"

    const val android_junit5: String = "1.4.2.1" // available: "1.6.2.0"

    const val de_mannodermaus_junit5: String = "1.1.0" // available: "1.2.0"

    const val io_mockk: String = "1.9" // available: "1.10.0"

    const val rxandroid: String = "2.1.1" 

    const val rxjava: String = "2.2.10" // available: "2.2.19"

    const val rxkotlin: String = "2.3.0" // available: "2.4.0"

    const val junit: String = "4.12" // available: "4.13"

    const val org_jetbrains_kotlin: String = "1.3.60" // available: "1.3.72"

    const val org_junit_jupiter: String = "5.5.0" // available: "5.6.2"

    const val dependency_check_gradle: String = "5.3.2" // available: "5.3.2.1"

    /**
     *
     *   To update Gradle, edit the wrapper file at path:
     *      ./gradle/wrapper/gradle-wrapper.properties
     */
    object Gradle {
        const val runningVersion: String = "5.6.2"

        const val currentVersion: String = "6.5"

        const val nightlyVersion: String = "6.6-20200627220025+0000"

        const val releaseCandidate: String = ""
    }
}
