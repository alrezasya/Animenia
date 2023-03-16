package com.rezaalamsyah.animenia.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.rezaalamsyah.animenia.R
import com.rezaalamsyah.animenia.databinding.FragmentAnimeDetailBinding
import com.rezaalamsyah.core.domain.model.Anime
import com.rezaalamsyah.core.ui.base.BaseFragment
import com.rezaalamsyah.core.utils.Variables
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment : BaseFragment() {

    private var _binding: FragmentAnimeDetailBinding? = null
    private val binding get() = _binding!!
    private var animeData: Anime? = null
    private var isFromFav: Boolean? = null
    private val viewModel: AnimeDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onSetView() {
        super.onSetView()
        animeData = arguments?.getParcelable(Variables.ANIME_DATA_KEY)
        isFromFav = arguments?.getBoolean(Variables.TO_DETAIL_KEY, false)
        setToolbar(
            toolbar = binding.toolbar,
            title = animeData?.title,
            isChild = true,
            onMenuAction = {
                if (isFromFav == true) {
                    requireActivity().onBackPressed()
                } else {
                    hostController.popBackStack()
                }
                true
            }
        )
        setDetailView()
    }

    @SuppressLint("SetTextI18n")
    private fun setDetailView() {
        binding.apply {
            Glide.with(requireContext())
                .load(animeData?.image)
                .into(imgAnime)
            tvTitleValue.text = animeData?.title
            tvSourceValue.text = animeData?.source
            tvDurationValue.text = animeData?.duration
            tvAiringValue.text = animeData?.status
            tvEpsValue.text = "${animeData?.episodes} episodes"
            tvScoreValue.text = "Score ${animeData?.score} and scored by ${animeData?.scoredBy}"
            tvSynopsisValue.text = animeData?.synopsis
            tvRatingValue.text = animeData?.rating
        }
        setFavorite(animeData?.isFavorite ?: false)
    }

    private fun setFavorite(status: Boolean) {
        if (status) {
            binding.btnFav.setCompoundDrawablesWithIntrinsicBounds(
                ResourcesCompat.getDrawable(requireContext().resources, R.drawable.ic_heart_like, null),
                null,
                null,
                null
            )
        } else {
            binding.btnFav.setCompoundDrawablesWithIntrinsicBounds(
                ResourcesCompat.getDrawable(requireContext().resources, R.drawable.ic_heart_unlike, null),
                null,
                null,
                null
            )
        }
    }

    override fun onSetAction() {
        super.onSetAction()
        var statusFavorite = animeData?.isFavorite ?: false
        binding.apply {
            btnFav.setOnClickListener {
                statusFavorite = !statusFavorite
                animeData?.let { it1 -> viewModel.setFavoriteAnime(it1, statusFavorite) }
                setFavorite(statusFavorite)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}