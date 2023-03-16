package com.example.displayproductionofficial.fragmentHome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.displayproductionofficial.R
import java.text.SimpleDateFormat
import java.util.*


class ClaimFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_claim, container, false)
        val textView = rootView.findViewById<TextView>(R.id.tanggal)

        val currentDate = Date()
        val dateFormat = SimpleDateFormat("EEEE, dd MMM yyyy", Locale("id", "ID"))
        val formattedDate = dateFormat.format(currentDate)



        textView.text = formattedDate
        return rootView
    }
}