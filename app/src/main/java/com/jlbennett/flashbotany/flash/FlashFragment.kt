package com.jlbennett.flashbotany.flash


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.jlbennett.flashbotany.R
import com.jlbennett.flashbotany.databinding.FragmentFlashBinding
import com.veinhorn.scrollgalleryview.MediaInfo
import com.veinhorn.scrollgalleryview.ScrollGalleryView
import com.veinhorn.scrollgalleryview.loader.DefaultImageLoader
import com.veinhorn.scrollgalleryview.loader.picasso.PicassoImageLoader


class FlashFragment : Fragment() {

    private lateinit var binding: FragmentFlashBinding
    private lateinit var viewModel: FlashViewModel
    private lateinit var gallery: ScrollGalleryView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_flash, container, false)
        viewModel = ViewModelProvider(this).get(FlashViewModel::class.java)
        gallery = binding.galleryView

        setupGallery()

        binding.hintButton.setOnClickListener {
            val action = FlashFragmentDirections.actionFlashFragmentToInfoFragment()
            findNavController().navigate(action)
        }


        viewModel.imageList.observe(viewLifecycleOwner, Observer { imageURLs ->
            gallery.setThumbnailSize(150)
            gallery.setZoom(true)
            gallery.setFragmentManager(childFragmentManager)
            gallery.addMedia(MediaInfo.mediaLoader(DefaultImageLoader(R.drawable.blackberry)))
            gallery.addMedia(MediaInfo.mediaLoader(DefaultImageLoader(R.drawable.rosa)))
            gallery.addMedia(MediaInfo.mediaLoader(DefaultImageLoader(R.drawable.lamium)))
            imageURLs.forEach { url ->
                Log.d("Flash VM", "url: $url")
                gallery.addMedia(MediaInfo.mediaLoader(PicassoImageLoader(url)))
            }
            gallery.buildLayer()
        })

        return binding.root
    }

    private fun setupGallery() {

    }
}
