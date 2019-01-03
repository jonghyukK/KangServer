package com.mac.kangserver.controller

import com.mac.kangserver.dao.VersionDao
import com.mac.kangserver.service.VersionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class VersionController(
        @Autowired val versionService: VersionService
){



    /******************************************************************************************
     *
     *     Check Update between Local and Server.
     *
     ******************************************************************************************/
    @GetMapping("/checkUpdate")
    fun checkUpdate(@RequestParam localVersion: Int): ResponseEntity<VersionDao> {

        val versionDbData = versionService.checkUpdate()
        var resultData    = VersionDao(false, false)

        when {

            // local == server ( Update 불필요 )
            (localVersion == versionDbData.playstoreVersion) -> resultData.needUpdate = false

            // local < server ( Update 필요 )
            (localVersion < versionDbData.playstoreVersion) -> {
                resultData.needUpdate      = true
                resultData.needForceUpdate = versionDbData.needForceUpdate == "Y"
            }
        }

        return ResponseEntity(resultData, HttpStatus.OK)
    }
}