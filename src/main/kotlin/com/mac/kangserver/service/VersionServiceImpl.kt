package com.mac.kangserver.service

import com.mac.kangserver.dao.VersionDBDao
import com.mac.kangserver.dao.VersionDao
import com.mac.kangserver.mapper.VersionMapper
import org.springframework.stereotype.Service


@Service
class VersionServiceImpl (
        val versionMapper: VersionMapper
): VersionService {

    override fun checkUpdate(): VersionDBDao = versionMapper.checkUpdate()
}