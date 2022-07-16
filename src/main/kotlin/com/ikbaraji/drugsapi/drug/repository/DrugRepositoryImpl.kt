package com.ikbaraji.drugsapi.drug.repository

import com.ikbaraji.drugsapi.database.DatabaseComponent
import com.ikbaraji.drugsapi.drug.entity.Drug
import com.mongodb.client.MongoCollection
import org.litote.kmongo.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class DrugRepositoryImpl : DrugRepository {

    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    override fun getDrugs(): List<Drug> {
        return databaseComponent.drugsCollection().find().toList()
    }

    override fun getDrugById(id: String): Drug? {
        return databaseComponent.drugsCollection().findOne { Drug::id eq id }
    }

    override fun getDrugsByName(name: String): List<Drug>? {
        return databaseComponent.drugsCollection().find(Drug::name regex ".*$name.*").toList()
    }

    override fun addDrug(drug: Drug): Drug? {
        val insertAction = databaseComponent.drugsCollection().insertOne(drug)
        if(insertAction.wasAcknowledged()){
            return drug
        } else {
            throw IllegalStateException("Insertion Failed $drug")
        }
    }

    override fun updateDrug(id: String, drug: Drug): Drug? {
        return databaseComponent.drugsCollection().findOneAndUpdate(Drug::id eq id, set(Drug::name setTo drug.name))
    }

    override fun deleteDrug(id: String): Drug? {
        return databaseComponent.drugsCollection().findOneAndDelete(Drug::id eq id)
    }


}