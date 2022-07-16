package com.ikbaraji.drugsapi.database

import com.ikbaraji.drugsapi.drug.entity.Drug
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import org.springframework.stereotype.Component

@Component
class DatabaseComponent {
    companion object {
        private const val DB_URL = "mongodb+srv://ikbarajihwl:Pancasila12@cluster0.mmhtg.mongodb.net/?retryWrites=true&w=majority"
    }

    private val databaseUrl = System.getenv(DB_URL)
    private val database: MongoClient = KMongo.createClient(DB_URL)

    fun drugsCollection(): MongoCollection<Drug> = database.getDatabase("drugs").getCollection()
}