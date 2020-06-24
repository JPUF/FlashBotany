package com.jlbennett.flashbotany.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.navigation.fragment.navArgs
import androidx.viewpager.widget.ViewPager
import com.jlbennett.flashbotany.R
import com.jlbennett.flashbotany.databinding.FragmentInfoBinding


class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private lateinit var pager: ViewPager
    private val args: InfoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)

        pager = binding.pager

        val pagerAdapter = InfoPageAdapter(childFragmentManager)
        pager.adapter = pagerAdapter
        return binding.root
    }

    private inner class InfoPageAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = 4

        //TODO read these from the SafeArgs
        //val names = listOf<String>("Rosaceae", "Asteraceae", "Boraginaceae", "Lamiaceae")
        val names: Array<String> = args.familyNames
        override fun getItem(position: Int): Fragment = InfoPageFragment(names[position])

        override fun getPageTitle(position: Int): CharSequence? {
            return names[position]
        }
    }
}