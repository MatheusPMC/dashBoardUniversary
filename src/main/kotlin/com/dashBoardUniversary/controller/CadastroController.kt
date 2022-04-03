package com.dashBoardUniversary.controller

import com.dashBoardUniversary.model.UserLogin
import com.dashBoardUniversary.port.KeyclockLoginSevicePort
import com.dashBoardUniversary.port.KeycloakSignUpServicePort
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule

@Controller("/api/")
class CadastroController(
    private val keyclockLoginSevicePort: KeyclockLoginSevicePort,
    private val userSignUpServicePort: KeycloakSignUpServicePort
) {

    @Post("register")
    @Secured(SecurityRule.IS_ANONYMOUS)
    fun createAccount(@Body user: UserLogin) {
        userSignUpServicePort.signUp(user)
    }

    @Post("login")
    @Secured(SecurityRule.IS_ANONYMOUS)
    fun loginAccount(@Body user: UserLogin): HttpResponse<*> {
        var result = keyclockLoginSevicePort.getTokenUser(user)
        return HttpResponse.ok(result)
    }

    @Get("adm")
    @Secured("viewer")
    @Produces
    fun listarTodos2() {
        println("entrou aqui como um viewer")
    }

    @Get("adm1")
    @Secured("teacher")
    @Produces
    fun listarTodos4() {
        println("entrou aqui como professor")
    }

    @Get("adm2")
    @Secured("admin")
    @Produces
    fun listarTodos3() {
        println("entrou aqui como administrador")
    }
}
