import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
    kotlin("multiplatform") apply false
    kotlin("jvm") apply false
}

group = "com.crowdproj.rating"
version = "0.0.1"

val javaVersion: String by project

allprojects {
    repositories{
        google()
        mavenCentral()
        maven{ url = uri("https://jitpack.io")}
    }
}

subprojects {

    group = rootProject.group
    version = rootProject.version

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = javaVersion
    }

    tasks.withType<KotlinJvmCompile> {
        kotlinOptions.jvmTarget = javaVersion
    }
}