package com.crowdproj.rating.ktor.plugin

import com.crowdproj.rating.ktor.CwpRatingAppSettings
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

fun Routing.swagger(appConfig: CwpRatingAppSettings) {
    get("/spec-crowdproj-ratings-{ver}.yaml") {
        val ver = call.parameters["ver"]
        val origTxt: String = withContext(Dispatchers.IO) {
            this::class.java.classLoader
                .getResource("specs/specs-ad-$ver.yaml")
                ?.readText()
        } ?: ""
        val response = origTxt.replace(
            Regex(
                "(?<=^servers:\$\\n).*(?=\\ntags:\$)",
                setOf(RegexOption.DOT_MATCHES_ALL, RegexOption.MULTILINE, RegexOption.IGNORE_CASE)
            ),
            appConfig.appUrls.joinToString(separator = "\n") { "  - url: $it$ver" }
        )
        call.respondText { response }
    }

    static("/") {
        preCompressed {
            defaultResource("index.html", "swagger-ui")
            resource("/swagger-initializer.js", "/swagger-initializer.js", "")
            static {
                staticBasePackage = "specs"
                resources(".")
            }
            static {
                preCompressed(CompressedFileType.GZIP) {
                    staticBasePackage = "swagger-ui"
                    resources(".")
                }
            }
        }
    }
}
