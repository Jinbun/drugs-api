package com.ikbaraji.drugsapi.drug.controller

import com.ikbaraji.drugsapi.BaseResponse
import com.ikbaraji.drugsapi.drug.entity.Drug
import com.ikbaraji.drugsapi.drug.service.DrugService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/drug")
class DrugController {

    @Autowired
    private lateinit var drugService: DrugService

    @GetMapping
    fun getDrugs(): BaseResponse<List<Drug>> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = drugService.getDrugs()
        )
    }

    @GetMapping("/{id}")
    fun getDrugById(@PathVariable(value = "id") id: String): BaseResponse<Drug> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = drugService.getDrugById(id)
        )
    }

    @GetMapping("/filter")
    fun getDrugByName(@RequestParam(value = "name") name: String): BaseResponse<List<Drug>> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = drugService.getDrugByName(name)
        )
    }

    @PostMapping("/add")
    fun addDrug(@RequestBody drug: Drug): BaseResponse<Drug> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = drugService.addDrug(drug)
        )
    }

    @PutMapping("/{id}")
    fun updateDrug(@PathVariable(value = "id") id: String, @RequestBody drug: Drug): BaseResponse<Drug> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = drugService.updateDrug(id, drug)
        )
    }

    @DeleteMapping("/{id}")
    fun deleteDrug(@PathVariable(value = "id") id: String): BaseResponse<Drug> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = drugService.deleteDrug(id)
        )
    }

}