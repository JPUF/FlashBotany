package com.jlbennett.flashbotany.flash

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jlbennett.flashbotany.data.Examples
import com.jlbennett.flashbotany.data.Family
import com.jlbennett.flashbotany.data.Species
import com.jlbennett.flashbotany.data.Examples.Families
import kotlin.random.Random

class FlashViewModel : ViewModel() {

    private val _currentFamily = MutableLiveData<Family>()
    val currentFamily: LiveData<Family>
        get() = _currentFamily

    private val _currentSpecies = MutableLiveData<Species>()
    val currentSpecies: LiveData<Species>
        get() = _currentSpecies

    private val _imageList = MutableLiveData<List<String>>()
    val imageList: LiveData<List<String>>
        get() = _imageList

    private val _familyList = MutableLiveData<List<String>>()
    val familyList: LiveData<List<String>>
        get() = _familyList

    init {
        nextFlower()
        _imageList.value = listOf<String>(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Rubus_fruticosus_Luc_Viatour.JPG/1280px-Rubus_fruticosus_Luc_Viatour.JPG",
            "https://cdn.britannica.com/60/175660-050-31EFCAF0/Flowers-blackberry.jpg",
            "https://4.bp.blogspot.com/-UVD44b6EnzA/WUh5xkpB2rI/AAAAAAAAbDc/SYRDKCabSiof7NrfKdGy_q1wXp_TKf6xQCLcBGAs/s1600/IMG_2324_2215.JPG"
        )

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

