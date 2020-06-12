package com.jlbennett.flashbotany.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.jlbennett.flashbotany.R
import com.jlbennett.flashbotany.databinding.FragmentInfoPageBinding
import com.veinhorn.scrollgalleryview.MediaInfo
import com.veinhorn.scrollgalleryview.loader.DefaultImageLoader

class InfoPageFragment(private val familyName: String) : Fragment() {

    private lateinit var binding: FragmentInfoPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_info_page, container, false)
        binding.titleText.text = familyName

        setupGallery()

        return binding.root
    }

    private fun setupGallery() {
        val gallery = binding.galleryView
        gallery.setThumbnailSize(150)
        gallery.setZoom(true)
        gallery.setFragmentManager(parentFragmentManager)
        gallery.addMedia(MediaInfo.mediaLoader(DefaultImageLoader(R.drawable.blackberry)))
        gallery.addMedia(MediaInfo.mediaLoader(DefaultImageLoader(R.drawable.rosa)))
        gallery.addMedia(MediaInfo.mediaLoader(DefaultImageLoader(R.drawable.lamium)))
        gallery.buildLayer()
    }
}