package com.mac.kangserver.controller

import com.mac.kangserver.dao.UserDao
import com.mac.kangserver.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController(
        @Autowired val userService: UserService
){


    /******************************************************************************************
     *
     *     SELECT All USERS.
     *
     ******************************************************************************************/
    @GetMapping("/user")
    fun selectAllUsers() : ResponseEntity<List<UserDao>> {

        val dao = userService.selectAllUsers()

        println("###############################################################################")
        for(i in 0..dao.size) {
            println("id  : ${dao[i].id}  \n" +
                    "pw1 : ${dao[i].pw1} \n" +
                    "pw2 : ${dao[i].pw2} \n" )}
        println("###############################################################################")

        return ResponseEntity(dao, HttpStatus.OK)
    }


    /******************************************************************************************
     *
     *     SELECT USER By ID
     *
     ******************************************************************************************/
    @GetMapping("/user/selectUserById")
    fun selectUserById(@RequestParam id: String): ResponseEntity<UserDao> {

        val dao = userService.selectUserById(id)

        println("###############################################################################")
        println("\n id  : ${dao.id }" +
                "\n pw1 : ${dao.pw1}" +
                "\n pw2 : ${dao.pw2}\n")
        println("###############################################################################")

        return ResponseEntity(dao, HttpStatus.OK)
    }


    /******************************************************************************************
     *
     *     Check Login ID / PW
     *
     ******************************************************************************************/
    @GetMapping("/user/checkLogin")
    fun checkLogin(@RequestParam id: String,
                   @RequestParam pw: String): ResponseEntity<String> {

        val dao = userService.selectUserById(id)

        return if (dao.id == id && dao.pw1 == pw) {
            ResponseEntity.status(HttpStatus.OK).body("MATCH")
        } else {
            ResponseEntity.status(HttpStatus.OK).body("MISMATCH")
        }
    }


    /******************************************************************************************
     *
     *     CREATE USER ONE.
     *
     ******************************************************************************************/
    @GetMapping("/user/createUser")
    fun createUser(@RequestParam id  : String,
                   @RequestParam pw1 : String,
                   @RequestParam pw2 : String) : ResponseEntity<UserDao> {

        val dao = UserDao(id, pw1, pw2)
        userService.createUser(dao)

        println("###############################################################################")
        println("\n id  : ${dao.id }" +
                "\n pw1 : ${dao.pw1}" +
                "\n pw2 : ${dao.pw2}\n")
        println("###############################################################################")

        return ResponseEntity.status(HttpStatus.OK).body(dao)
    }

}