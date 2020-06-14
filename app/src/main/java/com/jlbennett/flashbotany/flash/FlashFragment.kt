package com.jlbennett.flashbotany.flash


import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import androidx.core.view.children
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
    private var animationDuration: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_flash, container, false)
        viewModel = ViewModelProvider(this).get(FlashViewModel::class.java)
        gallery = binding.galleryView
        animationDuration = resources.getInteger(android.R.integer.config_shortAnimTime)

        binding.hintButton.setOnClickListener {
            val action = FlashFragmentDirections.actionFlashFragmentToInfoFragment()
            findNavController().navigate(action)
        }

        binding.firstPairLayout.children.forEach { button ->
            button.setOnClickListener { onAnswerClick() }
        }
        binding.secondPairLayout.children.forEach { button ->
            button.setOnClickListener { onAnswerClick() }
        }
        binding.nextButton.setOnClickListener { nextFlower() }

        viewModel.imageList.observe(viewLifecycleOwner, Observer { imageURLs ->
            gallery.setThumbnailSize(150)
            gallery.setZoom(true)
            gallery.setFragmentManager(childFragmentManager)
            //gallery.addMedia(MediaInfo.mediaLoader(DefaultImageLoader(R.drawable.blackberry)))
            imageURLs.forEach { url ->
                gallery.addMedia(MediaInfo.mediaLoader(PicassoImageLoader(url)))
            }
            gallery.buildLayer()
        })

        viewModel.familyList.observe(viewLifecycleOwner, Observer { familyNames ->
            binding.familyButton1.text = familyNames[0]
            binding.familyButton2.text = familyNames[1]
            binding.familyButton3.text = familyNames[2]
            binding.familyButton4.text = familyNames[3]
        })

        return binding.root
    }

    private fun onAnswerClick() {
        //TODO animate crossfade: https://developer.android.com/training/animation/reveal-or-hide-view
        //TODO Test with View.GONE for better performance.
//        binding.answerLayout.visibility = View.INVISIBLE
//        binding.feedbackLayout.visibility = View.VISIBLE
        crossfadeViews(R.id.feedbackLayout)
    }

    private fun nextFlower() {
//        binding.answerLayout.visibility = View.VISIBLE
//        binding.feedbackLayout.visibility = View.INVISIBLE
        crossfadeViews(R.id.answerLayout)
    }

    private fun crossfadeViews(targetViewID : Int) {
        val targetView: View; val visibleView: View
        if(targetViewID == R.id.feedbackLayout){
            targetView = binding.feedbackLayout
            visibleView = binding.answerLayout
        } else {
            targetView = binding.answerLayout
            visibleView = binding.feedbackLayout
        }

        targetView.apply {
            alpha = 0f
            visibility = View.VISIBLE

            animate()
                .alpha(1f)
                .setDuration(animationDuration.toLong())
                .setListener(null)
        }

        visibleView.animate()
            .alpha(1f)
            .setDuration(animationDuration.toLong())
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    visibleView.visibility = View.INVISIBLE
                }
            })
    }
}
