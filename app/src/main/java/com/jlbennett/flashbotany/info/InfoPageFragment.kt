package com.jlbennett.flashbotany.info

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.jlbennett.flashbotany.R
import com.jlbennett.flashbotany.data.Examples
import com.jlbennett.flashbotany.databinding.FragmentInfoPageBinding

class InfoPageFragment(private val familyName: String) : Fragment() {

    private lateinit var binding: FragmentInfoPageBinding
    private lateinit var imageSlider: ImageSlider
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_info_page, container, false)
        binding.titleText.text = familyName

        Log.d("InfoPage l", "onCreateView: $familyName")
        //TODO fix image loading bug.
        imageSlider = binding.imageSlider
        val currentFamily = Examples().getFamilyByName(familyName)
        val imageList = ArrayList<SlideModel>()
        currentFamily.exampleImageURLs.forEach { url ->
            imageList.add(SlideModel(url))
        }
        imageSlider.setImageList(imageList, true)

        return binding.root
    }

    override fun onPause() {
        super.onPause()
        Log.d("InfoPage l", "onPause: $familyName")
    }

    override fun onResume() {
        super.onResume()
        Log.d("InfoPage l", "onResume: $familyName")
    }
}