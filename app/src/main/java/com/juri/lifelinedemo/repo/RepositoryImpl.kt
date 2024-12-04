package com.juri.lifelinedemo.repo

import com.juri.lifelinedemo.data.LoginBody

class RepositoryImpl: Repository {

    private val listOfUsers = mapOf( "abc@xyz.com" to
        LoginBody(
            "abc@xyz.com",
            "Abc Xyz",
            "pass"
        )
    )

    override fun loginUser(loginBody: LoginBody): LoginBody? {

        val user = listOfUsers[loginBody.email] ?: return null

        if (user.password != loginBody.password) {
            return null
        }

        return user
    }
}