package com.appz.abhi.customview.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.appz.abhi.customview.R
import com.appz.abhi.customview.databinding.MainFragmentBinding

class MainFragment : Fragment() {


    // Data binding
    private lateinit var mainFragmentBinding: MainFragmentBinding


    // On fragment view creation starting
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the fragment layout
        mainFragmentBinding = DataBindingUtil
            .inflate(inflater, R.layout.main_fragment, container, false)

        // Return root view
        return mainFragmentBinding.root
    }


    // On fragment view creation completion
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize UI
        initUI()
    }


    // Initialize UI
    private fun initUI() {

    }


    companion object {


        // Logging constant
        private val TAG = MainFragment::class.java.simpleName
    }
}
