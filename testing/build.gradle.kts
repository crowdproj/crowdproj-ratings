import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    kotlin("multiplatform")
    id("io.kotest.multiplatform")  // для работы в kotest
}

kotlin {
    jvm {}
    js(IR) {
        browser()
    }

    val kotestVersion: String by project
    val coroutinesVersion: String by project
    val jUnitJupiterVersion: String by project

    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))

                implementation(kotlin("stdlib"))

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")

                implementation("io.kotest:kotest-framework-engine:$kotestVersion")
                implementation("io.kotest:kotest-framework-datatest:$kotestVersion")
                implementation("io.kotest:kotest-assertions-core:$kotestVersion")
                implementation("io.kotest:kotest-property:$kotestVersion")
                implementation("io.kotest:kotest-property-datetime:$kotestVersion")
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))

                // Alternatively, add the dependency to a specific target.
                // For example, we could add to the Javascript target only.
                // implementation("io.kotest:kotest-assertions-core:$kotestVersion")
                // implementation("io.kotest:kotest-property:$kotestVersion")
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit5"))
                implementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
                implementation("org.junit.jupiter:junit-jupiter-params:$jUnitJupiterVersion")
            }
        }
    }
}

tasks {
    withType<Test>().configureEach {
        //useJUnitPlatform необходимо для работы с junit5, в случае работы с junit (по умолчанию версия 4) эти настройки не нужны
        useJUnitPlatform {
//            includeTags.add("sampling")
        }

        filter {
            isFailOnNoMatchingTests = false
        }
        testLogging {
            showExceptions = true
            showStandardStreams = true
            events = setOf(TestLogEvent.FAILED, TestLogEvent.PASSED)
            exceptionFormat = TestExceptionFormat.FULL
        }
    }
}
