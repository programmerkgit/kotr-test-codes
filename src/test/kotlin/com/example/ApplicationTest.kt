package com.example

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.auth.*
import io.ktor.util.*
import io.ktor.auth.jwt.*
import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.locations.*
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.sessions.*
import io.ktor.auth.ldap.*
import io.ktor.features.*
import io.ktor.content.*
import io.ktor.http.content.*
import io.ktor.webjars.*
import java.time.*
import org.slf4j.event.*
import io.micrometer.prometheus.*
import io.ktor.metrics.micrometer.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import kotlin.test.*
import io.ktor.server.testing.*
import com.example.plugins.*

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ configureRouting() }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello World!", response.content)
            }
        }
    }
}