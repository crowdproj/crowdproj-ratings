import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

group = "com.crowdproj.rating"
version = "0.0.1"

val JVM_TARGET = "11"

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
        kotlinOptions.jvmTarget = JVM_TARGET
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile> {
        kotlinOptions.jvmTarget = JVM_TARGET
    }
}