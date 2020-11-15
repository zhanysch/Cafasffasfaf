package com.example.sambo.onBoard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sambo.R
import com.example.sambo.data.DataOnBoard
import kotlinx.android.synthetic.main.view_onboard.*

class OnBoardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         return inflater.inflate(R.layout.view_onboard, container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        val data = arguments?.get(DATA_ID) as DataOnBoard
        firstTitle.text = data.text
        imageWall.setImageResource(data.image)

    }

    companion object{
        const val DATA_ID = "DATA_ID"

        fun getInstance(data: DataOnBoard):OnBoardFragment{
            val fragment = OnBoardFragment()
            val bundle = Bundle()
            bundle.putParcelable(DATA_ID,data)
            fragment.arguments = bundle
            return fragment
        }
    }
}