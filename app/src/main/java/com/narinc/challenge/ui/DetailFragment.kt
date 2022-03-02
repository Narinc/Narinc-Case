package com.narinc.challenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.narinc.challenge.R
import com.narinc.challenge.databinding.FragmentDetailBinding
import com.narinc.challenge.domain.models.HomePageData
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Locale

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.title =
            if (HomePageData.Type.values()[args.type] == HomePageData.Type.MEDITATION) {
                getString(R.string.meditation_detail)
            } else getString(R.string.story_detail)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        binding.tvMediaTitle.text = args.detail.title
        binding.tvMediaContent.text = args.detail.content

        val df = SimpleDateFormat("yyyy/MM/dd, EEE", Locale.US)
        binding.tvMediaReleaseDate.text = df.format(args.detail.date?.toLong())
    }
}
