import org.gradle.api.Project
import versioning.AppVersion

/**
 * Created by novemio on 6/25/19.
 */
object Config {

    object Android {
        const val compileSdkVersion = 29
        const val minSdkVersion = 23
        const val targetVersion = 29
        const val instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        const val applicationId = "com.example.museum"

        fun versioning(project: Project) = AppVersion(project)
    }
}

