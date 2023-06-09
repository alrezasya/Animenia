package com.rezaalamsyah.favorite.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.rezaalamsyah.core.ui.adapter.AnimeAdapter
import com.rezaalamsyah.core.ui.base.BaseActivity
import com.rezaalamsyah.core.utils.Variables
import com.rezaalamsyah.core.utils.gone
import com.rezaalamsyah.core.utils.visible
import com.rezaalamsyah.favorite.R
import com.rezaalamsyah.favorite.databinding.ActivityFavoriteBinding
import com.rezaalamsyah.favorite.di.favModule
import org.koin.core.context.loadKoinModules
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteActivity: BaseActivity() {

    private lateinit var binding: ActivityFavoriteBinding

    private val viewModel: FavoriteViewModel by viewModel()

    private val animeAdapter = AnimeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadKoinModules(favModule)

        onSetView()
        onSetAction()
        onSetObserver()
    }

    private fun onSetView() {
        setAdapter()
        setToolbar(
            toolbar = binding.toolbar,
            title = getString(R.string.text_fav_anime),
            isChild = true,
            onMenuAction = {
                onBackPressed()
                true
            }
        )
    }

    private fun onSetAction() {
        animeAdapter.onItemClick = { data ->
            val uri = Uri.parse("animenia://main")
            val intent = Intent(Intent.ACTION_VIEW, uri).apply {
                putExtra(Variables.ANIME_DATA_KEY, data)
                putExtra(Variables.TO_DETAIL_KEY, true)
            }
            startActivity(intent)
        }
    }

    private fun onSetObserver() {
        viewModel.favoriteAnime.observe(this) { data ->
            animeAdapter.setData(data)
            if (data.isNotEmpty()) {
                viewStateOnSuccess()
            } else {
                viewStateOnFailure()
            }
        }
    }

    private fun viewStateOnSuccess() {
        binding.apply {
            rvAnime.visible()
            viewError.root.gone()
        }
    }

    private fun viewStateOnFailure() {
        binding.apply {
            rvAnime.gone()
            binding.viewError.root.visible()
            binding.viewError.tvError.text = getString(R.string.text_no_data)
        }
    }

    private fun setAdapter() {
        binding.rvAnime.apply {
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = animeAdapter
        }
    }
}