package com.example.am3y

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.viewpager.widget.ViewPager
import com.example.am3y.ui.main.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionbar = supportActionBar
        if (actionbar != null) {
            actionbar.setBackgroundDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.gradient_bg, null))
        }
        setContentView(R.layout.activity_main)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        setupViewPager(viewPager)
        val tabs: TabLayout = this.findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        setupTabIcons()
        viewPager.setCurrentItem(1)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = SectionsPagerAdapter(this@MainActivity, getSupportFragmentManager())
        adapter.addFragment(TabContactActivity(), "Contats")
        adapter.addFragment(TabHomeActivity(), "Home")
        adapter.addFragment(TabInfoActivity(), "Info")
        viewPager.adapter = adapter
    }

    private fun setupTabIcons() {
        tabs.getTabAt(0)?.setIcon(R.drawable.contact);
        tabs.getTabAt(1)?.setIcon(R.drawable.home);
        tabs.getTabAt(2)?.setIcon(R.drawable.features);
    }

    override fun onBackPressed()
    {
        super.onBackPressed();
        finish();
    }
}