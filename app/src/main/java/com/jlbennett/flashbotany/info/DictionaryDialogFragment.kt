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
        return binding.root
    }
}