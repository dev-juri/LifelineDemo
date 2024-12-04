package com.juri.lifelinedemo.repo

import com.juri.lifelinedemo.data.LoginBody

interface Repository {

    fun loginUser(loginBody: LoginBody): LoginBody?
}