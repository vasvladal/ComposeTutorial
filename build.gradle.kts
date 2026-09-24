// Top-level build file where you can add configuration options common to all sub-projects/modules.
// Plugin versions themselves live in gradle/libs.versions.toml (the version
// catalog) and are referenced here via the auto-generated `libs` accessor.
plugins {
alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
    //alias(libs.plugins.compose.compiler) apply false
}
