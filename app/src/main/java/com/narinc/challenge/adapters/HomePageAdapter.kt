package com.narinc.challenge.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.narinc.challenge.BaseAdapter
import com.narinc.challenge.databinding.ItemCardMessageBinding
import com.narinc.challenge.databinding.ItemHorizontalRecyclerviewBinding
import com.narinc.challenge.databinding.ItemVerticalRecyclerviewBinding
import com.narinc.challenge.domain.models.HomePageData
import com.narinc.challenge.domain.models.HomePageItem
import com.narinc.challenge.models.MediaDetail
import com.narinc.challenge.ui.HomeFragmentDirections
import com.narinc.challenge.util.SpaceItemDecoration
import javax.inject.Inject

class HomePageAdapter @Inject constructor(
    private val horizontalItemAdapter: HorizontalItemAdapter,
    private val verticalItemAdapter: VerticalItemAdapter
) : BaseAdapter<HomePageData>() {

    private val diffCallback = object : DiffUtil.ItemCallback<HomePageData>() {
        override fun areItemsTheSame(oldItem: HomePageData, newItem: HomePageData): Boolean {
            return oldItem.type == newItem.type
        }

        override fun areContentsTheSame(oldItem: HomePageData, newItem: HomePageData): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun getItemViewType(position: Int): Int {
        return list[position].type.value
    }

    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HomePageData.Type.MEDITATION.value -> {
                MeditationViewHolder(
                    ItemHorizontalRecyclerviewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            HomePageData.Type.CARD.value -> {
                CardMessageViewHolder(
                    ItemCardMessageBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            HomePageData.Type.STORY.value -> {
                StoryViewHolder(
                    ItemVerticalRecyclerviewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                throw UnsupportedOperationException("Unknown view type!")
            }
        }
    }

    inner class MeditationViewHolder(private val binding: ItemHorizontalRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root), Binder<HomePageData> {
        override fun bind(item: HomePageData) {
            item.items?.let {
                horizontalItemAdapter.list = it
            }
            horizontalItemAdapter.setItemClickListener {
                binding.root.findNavController().navigate(
                    navigate(it, HomePageData.Type.MEDITATION)
                )
            }
            binding.apply {
                val snapHelper = LinearSnapHelper()
                snapHelper.attachToRecyclerView(rvMeditations)
                rvMeditations.adapter = horizontalItemAdapter
                rvMeditations.addItemDecoration(SpaceItemDecoration.create(root.context.resources.displayMetrics))
            }
        }
    }

    inner class CardMessageViewHolder(binding: ItemCardMessageBinding) :
        RecyclerView.ViewHolder(binding.root), Binder<HomePageData> {
        override fun bind(item: HomePageData) {
            // no action
        }
    }

    inner class StoryViewHolder(private val binding: ItemVerticalRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root), Binder<HomePageData> {
        override fun bind(item: HomePageData) {
            item.items?.let {
                verticalItemAdapter.list = it
            }
            verticalItemAdapter.setItemClickListener {
                binding.root.findNavController().navigate(
                    navigate(it, HomePageData.Type.STORY)
                )
            }
            binding.apply {
                rvStories.adapter = verticalItemAdapter
                rvStories.addItemDecoration(SpaceItemDecoration.create(root.context.resources.displayMetrics))
            }
        }
    }

    private fun navigate(it: HomePageItem, type: HomePageData.Type) =
        HomeFragmentDirections.actionHomeFragmentToDetailFragment(
            MediaDetail(
                title = it.title,
                subtitle = it.subtitle,
                image = it.image?.large,
                date = it.date,
                content = it.content
            ),
            type.value
        )
}
