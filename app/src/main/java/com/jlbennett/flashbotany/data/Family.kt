package com.jlbennett.flashbotany.data

data class Family(val name: String, val infoResID: Int, val exampleImageURLs: List<String>, val members: List<Species>)