package com.ikbaraji.drugsapi.database

import com.ikbaraji.drugsapi.drug.entity.Drug
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import org.springframework.stereotype.Component

@Component
class DatabaseComponent {
    private val databaseUrl = System.getenv("DATABASE_URL")
    private val database: MongoClient = KMongo.createClient(databaseUrl)

    fun drugsCollection(): MongoCollection<Drug> = database.getDatabase("drugs").getCollection()
}