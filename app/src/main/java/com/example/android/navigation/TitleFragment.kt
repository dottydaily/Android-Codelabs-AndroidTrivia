package com.example.android.navigation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavAction
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
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

        // manage ui behavior
        binding.playButton.setOnClickListener {
            it.findNavController().navigate(
                    TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }
        binding.rulesButton.setOnClickListener {
            it.findNavController().navigate(
                    TitleFragmentDirections.actionTitleFragmentToRulesFragment())
        }
        binding.aboutButton.setOnClickListener {
            it.findNavController().navigate(
                    TitleFragmentDirections.actionTitleFragmentToAboutFragment())
        }

        // enable option menu
        setHasOptionsMenu(true)

        Log.i("TitleFragment", "onCreateView called")

        return binding.root
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.i("TitleFragment", "onAttach called")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("TitleFragment", "onCreate called")
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("TitleFragment", "onActivityCreated called")
    }
    override fun onStart() {
        super.onStart()
        Log.i("TitleFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("TitleFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("TitleFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("TitleFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("TitleFragment", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("TitleFragment", "onDetach called")
    }

    // add and inflate option menu to this fragment
    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu, menu)
    }

    // handle action when select the menu
    /**
     * About method : onNavDestinationSelected(item: [MenuItem], navController: [NavController])
     * It assumes the menu item id matches a valid action id or destination id to be navigated to.
     * If the item's id match with the fragment's id, then the app will be navigate to that fragment.
     */
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}