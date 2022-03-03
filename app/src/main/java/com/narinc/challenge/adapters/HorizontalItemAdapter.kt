package com.narinc.challenge.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.narinc.challenge.BaseAdapter
import com.narinc.challenge.databinding.ItemMeditationBinding
import com.narinc.challenge.domain.models.HomePageItem
import javax.inject.Inject

class HorizontalItemAdapter @Inject constructor(
    private val glide: RequestManager
) : BaseAdapter<HomePageItem>() {

    private val diffCallback = object : DiffUtil.ItemCallback<HomePageItem>() {
        override fun areItemsTheSame(oldItem: HomePageItem, newItem: HomePageItem): Boolean {
            return oldItem.date == newItem.date
        }

        override fun areContentsTheSame(oldItem: HomePageItem, newItem: HomePageItem): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MeditationViewHolder(
            ItemMeditationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    inner class MeditationViewHolder(private val binding: ItemMeditationBinding) :
        RecyclerView.ViewHolder(binding.root), Binder<HomePageItem> {
        override fun bind(item: HomePageItem) {
            binding.apply {
                tvMeditationTitle.text = item.title
                tvMeditationSubtitle.text = item.subtitle
                glide.load(item.image?.small).into(ivMeditation)
                root.setOnClickListener {
                    onItemClickListener?.let { itemClick ->
                        itemClick(item)
                    }
                }
            }
        }
    }
}
