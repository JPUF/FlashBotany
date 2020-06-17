package com.jlbennett.flashbotany.data

data class Family(val name: String, val info: String, val exampleImageURLs: List<String>, val members: List<Species>)