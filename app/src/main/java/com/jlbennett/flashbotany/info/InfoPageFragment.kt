package com.jlbennett.flashbotany.info

import android.os.Bundle
import android.text.Annotation
import android.text.SpannableString
import android.text.Spanned
import android.text.SpannedString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
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
import com.jlbennett.flashbotany.R.layout
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
        binding = DataBindingUtil.inflate(inflater, layout.fragment_info_page, container, false)
        binding.titleText.text = familyName
        imageSlider = binding.imageSlider
        val storageRef = Firebase.storage.reference
        val currentFamily = Examples().getFamilyByName(familyName)
        val imageList = ArrayList<SlideModel>()
        currentFamily.exampleImageURLs.forEach { path ->
            storageRef.child(path).downloadUrl.addOnFailureListener {
                Log.d("InfoPage", "Failed: ${it.localizedMessage}")
            }.addOnSuccessListener {
                Log.d("InfoPage", "On succ. ${it.toString()}")
                imageList.add(SlideModel(it.toString()))
                imageSlider.setImageList(imageList, true)
            }
        }
        binding.infoText.text = resources.getString(currentFamily.infoResID)
        setInfoText(currentFamily.infoResID)

        return binding.root
    }

    private fun setInfoText(infoResID: Int) {
        val rawText = getText(infoResID)
        val infoText = SpannedString(rawText)
        val spannable = SpannableString(infoText)
        val annotations = infoText.getSpans(0, infoText.length, Annotation::class.java)

        annotations.asList().forEach {
            val clickableSpan = object : ClickableSpan() {
                override fun onClick(view: View) {
                    showDictionaryDialog(it.value)
                }

                override fun updateDrawState(ds: TextPaint) {
                    super.updateDrawState(ds)
                }
            }
            spannable.apply {
                setSpan(
                    clickableSpan,
                    infoText.getSpanStart(it),
                    infoText.getSpanEnd(it),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }
        binding.infoText.apply {
            text = spannable
            movementMethod = LinkMovementMethod.getInstance()
        }
    }


    private fun showDictionaryDialog(term: String) {
        val fragmentManager = childFragmentManager
        val dictionaryDialogFragment = DictionaryDialogFragment(term)
        dictionaryDialogFragment.show(fragmentManager, "fragment_dictionary")
    }
}