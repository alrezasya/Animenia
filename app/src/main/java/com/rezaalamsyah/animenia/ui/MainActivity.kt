package com.rezaalamsyah.animenia.ui

import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import com.rezaalamsyah.animenia.R
import com.rezaalamsyah.animenia.databinding.ActivityMainBinding
import com.rezaalamsyah.core.domain.model.Anime
import com.rezaalamsyah.core.ui.base.BaseActivity
import com.rezaalamsyah.core.utils.Variables
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHost(R.id.fcv_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        val data = intent.getParcelableExtra<Anime>(Variables.ANIME_DATA_KEY)
        val toDetail = intent.getBooleanExtra(Variables.TO_DETAIL_KEY, false)
        startDestination(toDetail, data)
    }

    private fun startDestination(toDetail: Boolean, data: Anime?) {
        val graph = getController().navInflater.inflate(R.navigation.nav_main)
        val bundle = bundleOf()
        if (toDetail) {
            bundle.putParcelable(Variables.ANIME_DATA_KEY, data)
            bundle.putBoolean(Variables.TO_DETAIL_KEY, toDetail)
            graph.startDestination = R.id.animeDetailFragment
        } else {
            graph.startDestination = R.id.homeFragment
        }
        getController().setGraph(graph, bundle)
    }

}