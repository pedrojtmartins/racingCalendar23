pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "RacingCalendar23"
include(":app")
include(":core:database")
include(":core:races")
include(":core:configVersion")
include(":core:cloudStore")
include(":core:common")
