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
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
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
        imageSlider = binding.imageSlider
        val storageRef = Firebase.storage.reference
        val currentFamily = Examples().getFamilyByName(familyName)
        val imageList = ArrayList<SlideModel>()
        currentFamily.exampleImageURLs.forEach { path ->
            storageRef.child(path).downloadUrl.addOnFailureListener {
                Log.d("InfoPage", "Failed: ${it.localizedMessage}")
            }.addOnSuccessListener {
                Log.d("FlashFrag", "On succ. ${it.toString()}")
                imageList.add(SlideModel(it.toString()))
                imageSlider.setImageList(imageList, true)
            }
        }
        binding.infoText.text = currentFamily.info

        binding.showButton.setOnClickListener { showDictionaryDialog() }

        return binding.root
    }

    private fun showDictionaryDialog() {
        val fragmentManager = childFragmentManager
        val dictionaryDialogFragment = DictionaryDialogFragment("Title Term ye yee")
        dictionaryDialogFragment.show(fragmentManager, "fragment_dictionary")
    }
}