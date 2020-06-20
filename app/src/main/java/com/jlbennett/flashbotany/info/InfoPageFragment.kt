package com.jlbennett.flashbotany.info

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.jlbennett.flashbotany.R
import com.jlbennett.flashbotany.databinding.FragmentInfoPageBinding
import com.jlbennett.flashbotany.data.Examples
import com.jlbennett.flashbotany.data.Family
import com.veinhorn.scrollgalleryview.MediaInfo
import com.veinhorn.scrollgalleryview.ScrollGalleryView
import com.veinhorn.scrollgalleryview.loader.picasso.PicassoImageLoader

class InfoPageFragment(private val familyName: String) : Fragment() {

    private lateinit var binding: FragmentInfoPageBinding
    private lateinit var gallery: ScrollGalleryView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_info_page, container, false)
        binding.titleText.text = familyName

        Log.d("InfoPage l", "onCreateView: $familyName")
        //TODO fix image loading bug.
        gallery = binding.galleryView
        gallery.setThumbnailSize(150)
        gallery.setZoom(true)
        gallery.setFragmentManager(childFragmentManager)
        val currentFamily = Examples().getFamilyByName(familyName)
        currentFamily.exampleImageURLs.forEach { url ->
            gallery.addMedia(MediaInfo.mediaLoader(PicassoImageLoader(url)))
        }

        gallery.buildLayer()

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