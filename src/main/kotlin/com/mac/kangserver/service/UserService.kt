package com.mac.kangserver.service

import com.mac.kangserver.dao.UserDao


interface UserService {

    fun selectAllUsers(): List<UserDao>
    fun selectUserById(userId: String) : UserDao
    fun createUser(userDao: UserDao): UserDao
}