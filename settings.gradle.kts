pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "shift-pogrebiczkij-2025"
include(":app")

include(":feature:authorization")
include(":feature:bank_addresses")
include(":feature:loan_details")
include(":feature:loan_history")
include(":feature:loan_processing")
include(":feature:main_page")
include(":feature:menu")
include(":feature:onboarding")

include(":core")

include(":shared:design")
