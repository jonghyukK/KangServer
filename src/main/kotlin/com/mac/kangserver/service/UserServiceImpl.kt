package com.mac.kangserver.service

import com.mac.kangserver.dao.UserDao
import com.mac.kangserver.mapper.UserMapper
import org.springframework.stereotype.Service


@Service
class UserServiceImpl(
        val userMapper: UserMapper
): UserService {

    override fun selectAllUsers(): List<UserDao>         = userMapper.selectAllUsers()
    override fun selectUserById(userId: String): UserDao = userMapper.selectUserById(userId)
    override fun createUser(userDao: UserDao): UserDao   = userMapper.createUser(userDao)
}