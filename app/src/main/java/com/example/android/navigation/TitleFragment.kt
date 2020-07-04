package com.example.android.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.android.navigation.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {

    /**
     * These are parameters that passed to the inflate method of DataBindingUtil
     *
     * - inflater, which is the LayoutInflater used to inflate the binding layout.
     * - The XML layout resource of the layout to inflate.
     *   Use one of the layouts that is already defined for you, R.layout.fragment_title.
     * - container for the parent ViewGroup. (This parameter is optional.)
     * - false for the attachToParent value.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(
                inflater, R.layout.fragment_title, container, false)
        return binding.root
    }


}