package com.jlbennett.flashbotany.flash


import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.jlbennett.flashbotany.R
import com.jlbennett.flashbotany.databinding.FragmentFlashBinding

//TODO source copyright free images... iNat noCopy.
//TODO fix the name selection issue.. (all four families are the same)
class FlashFragment : Fragment() {

    private lateinit var binding: FragmentFlashBinding
    private lateinit var viewModel: FlashViewModel
    private lateinit var imageSlider: ImageSlider
    private lateinit var currentFamilyName: String
    private var animationDuration: Int = 0
    private var familyNames = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_flash, container, false)
        viewModel = ViewModelProvider(this).get(FlashViewModel::class.java)
        val storageRef = Firebase.storage.reference
        imageSlider = binding.imageSlider

        animationDuration = resources.getInteger(android.R.integer.config_shortAnimTime)

        binding.hintButton.setOnClickListener {
            val action = FlashFragmentDirections.actionFlashFragmentToInfoFragment(familyNames.toTypedArray())
            findNavController().navigate(action)
        }

        binding.firstPairLayout.children.forEach { view ->
            val button = view as Button
            button.setOnClickListener { onAnswerClick(button.text as String) }
        }
        binding.secondPairLayout.children.forEach {view ->
            val button = view as Button
            button.setOnClickListener { onAnswerClick(button.text as String) }
        }

        binding.nextButton.setOnClickListener { onNextClick() }

        viewModel.currentFamily.observe(viewLifecycleOwner, Observer { family ->
            currentFamilyName = family.name
            val familyText = "It's ${family.name}"
            binding.correctFamilyText.text = familyText
        })

        viewModel.currentSpecies.observe(viewLifecycleOwner, Observer { species ->
            val imageList = ArrayList<SlideModel>()
            species.imageURLs.forEach {path ->
                storageRef.child(path).downloadUrl.addOnFailureListener {
                    Log.d("FlashFrag", "On fail. ${it.localizedMessage}")
                }.addOnSuccessListener {
                    Log.d("FlashFrag", "On succ. ${it.toString()}")
                    imageList.add(SlideModel(it.toString()))
                    imageSlider.setImageList(imageList, true)
                }
            }


            binding.scientificText.text = species.scientificName
            binding.vernacularText.text = species.vernacularName
        })

        viewModel.familyList.observe(viewLifecycleOwner, Observer { families ->
            familyNames = arrayListOf(families[0].name, families[1].name, families[2].name, families[3].name)
            binding.familyButton1.text = familyNames[0]
            binding.familyButton2.text = familyNames[1]
            binding.familyButton3.text = familyNames[2]
            binding.familyButton4.text = familyNames[3]
        })

        return binding.root
    }

    private fun onAnswerClick(familyName: String) {
        Log.d("FlashFrag", "AnswerClick: $familyName vs currentFamily: $currentFamilyName")
        if(familyName == currentFamilyName) {
            binding.feedbackText.text = resources.getString(R.string.correct)
        } else {
            binding.feedbackText.text = resources.getString(R.string.wrong)
        }
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
