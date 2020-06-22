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


    private val _familyList = MutableLiveData<List<String>>()
    val familyList: LiveData<List<String>>
        get() = _familyList

    init {
        nextFlower()

        //TODO family list should be based off the guessable family in FlashFragment
        _familyList.value = listOf<String>(
            "Lamiaceae", "Rosaceae", "Boraginaceae", "Asteraceae"
        )
    }

    fun nextFlower() {
        val randomFamilyIndex = (Examples.families.indices).random()
        _currentFamily.value = Examples.families[randomFamilyIndex]

        val randomSpeciesIndex = (_currentFamily.value!!.members.indices).random()
        _currentSpecies.value = _currentFamily.value!!.members[randomSpeciesIndex]

    }
}

