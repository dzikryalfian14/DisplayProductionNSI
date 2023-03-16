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


class MesinRusakFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_mesin_rusak, container, false)
        val textView = rootView.findViewById<TextView>(R.id.tanggal)
        val tanggalDownTime = rootView.findViewById<TextView>(R.id.tanggaldowntime)
        val tanggalDownTimebawah= rootView.findViewById<TextView>(R.id.tanggaldowntimebawah)

        val currentDate = Date()
        val dateFormat = SimpleDateFormat("EEEE, dd MMM yyyy", Locale("id", "ID"))
        val formattedDate = dateFormat.format(currentDate)

        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -30) // tambahkan 1 hari sebelumnya
        val formattedDate2 = dateFormat.format(calendar.time)


        textView.text = formattedDate
        tanggalDownTime.text = formattedDate
        tanggalDownTimebawah.text = formattedDate2

        return rootView
    }

}