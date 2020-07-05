package com.example.android.navigation

import android.os.Bundle
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

        return binding.root
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