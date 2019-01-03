package com.mac.kangserver.mapper

import com.mac.kangserver.dao.VersionDBDao
import com.mac.kangserver.dao.VersionDao
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository


@Repository
@Mapper
interface VersionMapper {

    fun checkUpdate(): VersionDBDao
}