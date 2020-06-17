package com.jlbennett.flashbotany.data

data class Species(
    val scientificName: String,
    val vernacularName: String,
    val imageURLs: List<String>
)