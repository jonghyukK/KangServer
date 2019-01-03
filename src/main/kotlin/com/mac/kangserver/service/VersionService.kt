package com.mac.kangserver.service

import com.mac.kangserver.dao.VersionDBDao
import com.mac.kangserver.dao.VersionDao


interface VersionService {

    fun checkUpdate(): VersionDBDao
}