package com.dashBoardUniversary.service

import com.dashBoardUniversary.model.UserLogin
import com.dashBoardUniversary.commons.extensions.TestLogging
import com.dashBoardUniversary.commons.extensions.logger
import com.dashBoardUniversary.port.KeyclockLoginSevicePort
import com.google.gson.JsonParser
import com.squareup.okhttp.MediaType
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.RequestBody
import io.micronaut.context.annotation.Prototype

@Prototype
class KeyclockLoginSevice: KeyclockLoginSevicePort, TestLogging {
    override fun getTokenUser(user: UserLogin): String? {
            val client = OkHttpClient()

            val mediaType = MediaType.parse("application/x-www-form-urlencoded")
            val body = RequestBody.create(mediaType,
                "username=${user.username}&password=${user.password}&grant_type=password&client_id=micronaut&client_secret=7Kbt5gVrf6MW8GcqLmP5bSNLRL8KPjxQ")
            val request = Request.Builder()
                .url("http://localhost:8080/realms/universary/protocol/openid-connect/token")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build()
            val response = client.newCall(request).execute()

        val responseBodyToString = response.body().string()
        val responseBodyToJson = JsonParser.parseString(responseBodyToString)

        if (responseBodyToString.contains("access_token")) {
            logger().info("getAccessTokenAdminCli - access_token capturado!")
            return responseBodyToJson.asJsonObject["access_token"].asString
        } else {
            logger().error("getAccessTokenAdminCli - access_token nÃ£o capturado!")
            throw java.lang.RuntimeException("KeycloakSingUpService - Token not received")
        }
    }
}