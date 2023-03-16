package com.example.displayproductionofficial.fragmentHome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.displayproductionofficial.R
import kotlinx.android.synthetic.main.fragment_production.*
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*



class ProductionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_production, container, false)
        val textView = rootView.findViewById<TextView>(R.id.tanggal3)

        val currentDate = Date()
        val dateFormat = SimpleDateFormat("EEEE, dd MMM yyyy", Locale("id", "ID"))
        val formattedDate = dateFormat.format(currentDate)

        textView.text = formattedDate

        // Mendefinisikan URL untuk mengambil data dari server
        val url = "http://192.168.33.158/API/report_produksi.php"

        // Membuat RequestQueue menggunakan library Volley
        val requestQueue = Volley.newRequestQueue(context)

        // Membuat request untuk mengambil data dari server
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                // Parsing JSON response menjadi objek JSONObject
                val jsonObject = JSONObject(response)

                // Mengambil data dari objek JSONObject
                val cam = jsonObject.getString("cam")
                val cncLine1 = jsonObject.getString("cnc_line1")
                val cncLine2 = jsonObject.getString("cnc_line2")
                val cncLine3 = jsonObject.getString("cnc_line3")

                // Menampilkan data pada CardView
                rootView.findViewById<TextView>(R.id.cam_text_view).text = cam
                rootView.findViewById<TextView>(R.id.cncline1_text_view).text  = cncLine1
                rootView.findViewById<TextView>(R.id.cncline2_text_view).text  = cncLine2
                rootView.findViewById<TextView>(R.id.cncline3_text_view).text  = cncLine3
            },
            { error ->
                // Menampilkan pesan error jika gagal mengambil data
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            })

        // Menambahkan request ke dalam RequestQueue
        requestQueue.add(stringRequest)

        return rootView
    }
}
