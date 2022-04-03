package com.dashBoardUniversary.port

import com.dashBoardUniversary.model.UserLogin

interface KeyclockLoginSevicePort {
    fun getTokenUser(user: UserLogin): String?
}
