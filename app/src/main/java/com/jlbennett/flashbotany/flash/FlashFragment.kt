package com.jlbennett.flashbotany.flash



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.veinhorn.scrollgalleryview.loader.picasso.dsl.DSL.image

import com.jlbennett.flashbotany.R
import com.jlbennett.flashbotany.databinding.FragmentFlashBinding
import com.squareup.picasso.Picasso
import com.veinhorn.scrollgalleryview.MediaInfo
import com.veinhorn.scrollgalleryview.loader.DefaultImageLoader


class FlashFragment : Fragment() {

    private lateinit var binding: FragmentFlashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_flash, container, false)

        val gallery = binding.galleryView
        gallery.setThumbnailSize(150)
        gallery.setZoom(true)
        gallery.setFragmentManager(parentFragmentManager)
        gallery.addMedia(MediaInfo.mediaLoader(DefaultImageLoader(R.drawable.blackberry)))
        gallery.addMedia(MediaInfo.mediaLoader(DefaultImageLoader(R.drawable.rosa)))
        gallery.addMedia(MediaInfo.mediaLoader(DefaultImageLoader(R.drawable.lamium)))
        gallery.buildLayer()
        return binding.root
    }
}
