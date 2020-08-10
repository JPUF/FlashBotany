package com.jlbennett.flashbotany.flash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jlbennett.flashbotany.data.Examples
import com.jlbennett.flashbotany.data.Family
import com.jlbennett.flashbotany.data.Species

class FlashViewModel : ViewModel() {

    private val _currentFamily = MutableLiveData<Family>()
    val currentFamily: LiveData<Family>
        get() = _currentFamily

    private val _currentSpecies = MutableLiveData<Species>()
    val currentSpecies: LiveData<Species>
        get() = _currentSpecies


    private val _familyList = MutableLiveData<List<Family>>()
    val familyList: LiveData<List<Family>>
        get() = _familyList

    init {
        nextFlower()
    }

    fun nextFlower() {
        val randomFamilyIndex = (Examples.families.indices).random()
        _currentFamily.value = Examples.families[randomFamilyIndex]

        val randomSpeciesIndex = (_currentFamily.value!!.members.indices).random()
        _currentSpecies.value = _currentFamily.value!!.members[randomSpeciesIndex]
        randomiseFamilyList()
    }

    private fun randomiseFamilyList() {
        val tempFamilyList = mutableListOf<Family>()
        while(tempFamilyList.size < 3) {
            val randomFamily = Examples.families.random()
            if (randomFamily != _currentFamily.value && randomFamily !in tempFamilyList)
                tempFamilyList.add(randomFamily)
        }
        tempFamilyList.add((0..2).random(), _currentFamily.value!!)
        _familyList.value = tempFamilyList.toList()
    }
}

