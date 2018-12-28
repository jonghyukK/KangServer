package com.mac.kangserver.mapper

import com.mac.kangserver.dao.UserDao
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository


@Repository
@Mapper
interface UserMapper {

    fun selectAllUsers(): List<UserDao>
    fun selectUserById(userId: String) : UserDao
    fun createUser(userDao: UserDao): UserDao
}