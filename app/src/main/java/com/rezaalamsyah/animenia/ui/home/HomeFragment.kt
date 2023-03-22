package com.rezaalamsyah.animenia.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.rezaalamsyah.animenia.R
import com.rezaalamsyah.animenia.databinding.FragmentHomeBinding
import com.rezaalamsyah.core.data.utils.Resource
import com.rezaalamsyah.core.ui.adapter.AnimeAdapter
import com.rezaalamsyah.core.ui.base.BaseFragment
import com.rezaalamsyah.core.utils.Variables
import com.rezaalamsyah.core.utils.gone
import com.rezaalamsyah.core.utils.installModule
import com.rezaalamsyah.core.utils.visible
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {

    private val viewModel: HomeViewModel by viewModel()
    private val animeAdapter = AnimeAdapter()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun goToFav() {
        val uri = Uri.parse("animenia://favorite")
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }

    override fun onSetView() {
        super.onSetView()
        setAdapter()
        setToolbar(
            toolbar = binding.toolbar,
            title = getString(R.string.text_animenia),
            isChild = false,
            menu = R.menu.main_menu,
            onMenuAction = {
                if (it == R.id.nav_fav) {
                    requireContext().installModule("favorite",
                    onSuccess = {
                        goToFav()
                    },
                    onFailure = {})
                } else {
                    hostController.popBackStack()
                }
                true
            }
        )
    }

    override fun onSetAction() {
        super.onSetAction()
        animeAdapter.onItemClick = { data ->
            val bundle = bundleOf()
            bundle.putParcelable(Variables.ANIME_DATA_KEY, data)
            hostController.navigate(R.id.action_homeFragment_to_animeDetailFragment, bundle)
        }
    }

    override fun onSetObserver() {
        super.onSetObserver()
        viewModel.animeResult.observe(viewLifecycleOwner) {
            if (it != null) {
                when (it) {
                    is Resource.Loading -> {
                        viewStateOnLoading()
                    }
                    is Resource.Success -> {
                        viewStateOnSuccess()
                        animeAdapter.setData(it.data)
                    }
                    is Resource.Error -> {
                        viewStateOnFailure()
                    }
                }
            }
        }
    }

    private fun viewStateOnLoading() {
        binding.apply {
            rvAnime.gone()
            progressCircular.visible()
            viewError.root.gone()
        }
    }

    private fun viewStateOnSuccess() {
        binding.apply {
            rvAnime.visible()
            progressCircular.gone()
            viewError.root.gone()
        }
    }

    private fun viewStateOnFailure() {
        binding.apply {
            rvAnime.gone()
            progressCircular.gone()
            binding.viewError.root.visible()
        }
    }

    private fun setAdapter() {
        binding.rvAnime.apply {
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = animeAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvAnime.adapter = null
        _binding = null
    }
}