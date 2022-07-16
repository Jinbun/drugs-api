package com.ikbaraji.drugsapi.drug.repository

import com.ikbaraji.drugsapi.drug.entity.Drug

interface DrugRepository {
    fun getDrugs(): List<Drug>
    fun getDrugById(id: String): Drug?
    fun getDrugsByName(name: String): List<Drug>?
    fun addDrug(drug: Drug): Drug?
    fun updateDrug(id: String, drug: Drug): Drug?
    fun deleteDrug(id: String): Drug?
}