package com.jlbennett.flashbotany.flash


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil

import com.jlbennett.flashbotany.R
import com.jlbennett.flashbotany.databinding.FragmentFlashBinding


class FlashFragment : Fragment() {

    private lateinit var binding: FragmentFlashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_flash, container, false)
        binding.familyButton1.setOnClickListener {
            if (binding.infoFragment.visibility == View.GONE)
                binding.infoFragment.visibility = View.VISIBLE
            else
                binding.infoFragment.visibility = View.GONE
        }

        return binding.root
    }
}
