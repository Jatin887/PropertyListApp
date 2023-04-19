package com.example.propertyapp.ui.screens.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import coil.load
import com.example.propertyapp.R
import com.example.propertyapp.common.Constants
import com.example.propertyapp.databinding.FragmentAboutBinding
import com.example.propertyapp.ui.screens.main.MainActivity
import com.google.android.material.appbar.MaterialToolbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AboutFragment : Fragment() {
    private lateinit var binding: FragmentAboutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configTopAppBar()
    }

    private fun configTopAppBar() {
        val topAppBar = (activity as MainActivity).findViewById<MaterialToolbar>(R.id.toolbar)
        topAppBar.menu.clear()
        val topAppBarTextView =
            (activity as MainActivity).findViewById<TextView>(R.id.toolbar_title)
        topAppBarTextView.text = Constants.ABOUT_FRAGMENT_TITLE
    }

}