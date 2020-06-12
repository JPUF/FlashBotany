package com.jlbennett.flashbotany.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.jlbennett.flashbotany.R
import com.jlbennett.flashbotany.databinding.FragmentInfoPageBinding

class InfoPageFragment(familyName: String) : Fragment() {

    private lateinit var binding: FragmentInfoPageBinding
    private val familyName: String = familyName

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_info_page, container, false)
        binding.titleText.text = familyName

        return binding.root
    }
}