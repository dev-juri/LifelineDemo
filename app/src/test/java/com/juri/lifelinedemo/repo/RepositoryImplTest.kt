package com.juri.lifelinedemo.repo

import com.juri.lifelinedemo.data.LoginBody
import org.junit.Assert.*

import org.junit.Test

class RepositoryImplTest {

    @Test
    fun `wrong email supplied, should return null, when email is incorrect`() {
        val given = LoginBody("abz@xyz.com", "Abc XYz", "pass")

        val expected = null

        val outcome = RepositoryImpl().loginUser(given)

        assertEquals(expected, outcome)
    }

    @Test
    fun `wrong password supplied, should return null, when password is incorrect`() {
        val given = LoginBody("abc@xyz.com", "Abc Xyz", "pess")

        val expected = null

        val outcome = RepositoryImpl().loginUser(given)

        assertEquals(expected, outcome)
    }

    @Test
    fun `correct input supplied, should return the body`() {
        val given = LoginBody("abc@xyz.com", "Abc Xyz", "pass")

        val outcome = RepositoryImpl().loginUser(given)

        assertEquals(given, outcome)
    }
}