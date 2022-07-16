package com.ikbaraji.drugsapi.drug.service

import com.ikbaraji.drugsapi.drug.entity.Drug
import com.ikbaraji.drugsapi.drug.repository.DrugRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DrugServiceImpl : DrugService{

    @Autowired
    private lateinit var drugRepository: DrugRepository
    override fun getDrugs(): List<Drug>? {
        return drugRepository.getDrugs()
    }

    override fun getDrugById(id: String): Drug? {
        return drugRepository.getDrugById(id)
    }

    override fun getDrugByName(name: String): List<Drug>? {
        return drugRepository.getDrugsByName(name)
    }

    override fun addDrug(drug: Drug): Drug? {
        return drugRepository.addDrug(drug)
    }

    override fun updateDrug(id: String, drug: Drug): Drug? {
        return drugRepository.updateDrug(id, drug)
    }

    override fun deleteDrug(id: String): Drug? {
        return drugRepository.deleteDrug(id)
    }


}