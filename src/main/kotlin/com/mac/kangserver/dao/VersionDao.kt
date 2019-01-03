package com.mac.kangserver.dao


data class VersionDao(var needUpdate     : Boolean,
                      var needForceUpdate: Boolean)

data class VersionDBDao(val playstoreVersion : Int,
                        val needForceUpdate  : String)