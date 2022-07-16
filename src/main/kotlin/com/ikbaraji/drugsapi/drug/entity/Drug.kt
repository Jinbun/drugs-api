package com.ikbaraji.drugsapi.drug.entity

import java.util.UUID

data class Drug(
    var id: String = UUID.randomUUID().toString(),
    var name : String = "",
    var price : Double = 0.0,
    var description : String = "",
)