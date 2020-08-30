package com.jlbennett.flashbotany.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.jlbennett.flashbotany.R
import com.jlbennett.flashbotany.databinding.FragmentDictionaryBinding

class DictionaryDialogFragment(private val title: String) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDictionaryBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dictionary, container, false)
        binding.titleText.text = title
        binding.definitionText.text = getText(termResID(title))
        return binding.root
    }

    private fun termResID(term: String) : Int {
        return when(term) {
            "Petal" -> R.string.petal
            "Sepal" -> R.string.sepal
            "Umbel" -> R.string.umbel
            "Stigma" -> R.string.stigma
            "Style" -> R.string.style
            "Ovary" -> R.string.ovary
            "Pistil" -> R.string.pistil
            "Stamen" -> R.string.stamen
            "Anther" -> R.string.anther
            "Whorl" -> R.string.whorl
            "Inflorescence" -> R.string.inflorescence
            "Serrated" -> R.string.serrated
            "Stipule" -> R.string.stipule
            "Monocot" -> R.string.monocot
            "Cyme" -> R.string.cyme
            "Floret" -> R.string.floret
            "Bract" -> R.string.bract
            "Verticillaster" -> R.string.verticillaster
            else -> R.string.errorDefinition
        }
    }
}