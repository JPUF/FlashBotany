package com.jlbennett.flashbotany.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jlbennett.flashbotany.R
import com.jlbennett.flashbotany.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.startCard.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFlashFragment())
        }
        binding.aboutCard.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAboutFragment())
        }

        return binding.root
    }
}
