package com.jlbennett.flashbotany.flash


import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.jlbennett.flashbotany.R
import com.jlbennett.flashbotany.databinding.FragmentFlashBinding

//TODO source copyright free images... iNat noCopy.

class FlashFragment : Fragment() {

    private lateinit var binding: FragmentFlashBinding
    private lateinit var viewModel: FlashViewModel
    private lateinit var imageSlider: ImageSlider
    private var animationDuration: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_flash, container, false)
        viewModel = ViewModelProvider(this).get(FlashViewModel::class.java)
        imageSlider = binding.imageSlider

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
        binding.nextButton.setOnClickListener { onNextClick() }

        viewModel.currentSpecies.observe(viewLifecycleOwner, Observer { species ->
            val imageList = ArrayList<SlideModel>()
            species.imageURLs.forEach { url ->
                imageList.add(SlideModel(url))
            }
            imageSlider.setImageList(imageList, true)
        })

        viewModel.familyList.observe(viewLifecycleOwner, Observer { families ->
            binding.familyButton1.text = families[0].name
            binding.familyButton2.text = families[1].name
            binding.familyButton3.text = families[2].name
            binding.familyButton4.text = families[3].name
        })

        return binding.root
    }

    private fun onAnswerClick() {
        //TODO improve animation. Maybe a horizontal swipe or smth
        crossfadeViews(R.id.feedbackLayout)
    }

    private fun onNextClick() {
        viewModel.nextFlower()
        crossfadeViews(R.id.answerLayout)
    }

    private fun crossfadeViews(targetViewID: Int) {
        val targetView: View;
        val visibleView: View
        if (targetViewID == R.id.feedbackLayout) {
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
