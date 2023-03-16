package com.example.displayproductionofficial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.displayproductionofficial.fragmentHome.ClaimFragment
import com.example.displayproductionofficial.fragmentHome.MesinRusakFragment
import com.example.displayproductionofficial.fragmentHome.ProductionFragment


class HomeActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewPager = findViewById(R.id.viewPager)
        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(ClaimFragment(), "Claim")
        adapter.addFragment(MesinRusakFragment(), "Mesin Rusak")
        adapter.addFragment(ProductionFragment(), "Production")

        viewPager.adapter = adapter
    }

}