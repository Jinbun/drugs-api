package com.ikbaraji.drugsapi.drug.service

import com.ikbaraji.drugsapi.drug.entity.Drug

interface DrugService {
    fun getDrugs(): List<Drug>?
    fun getDrugById(id: String): Drug?
    fun getDrugByName(name: String): List<Drug>?
    fun addDrug(drug: Drug): Drug?
    fun updateDrug(id: String, drug: Drug): Drug?
    fun deleteDrug(id: String): Drug?
}