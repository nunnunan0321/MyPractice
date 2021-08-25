package com.example.myhobby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.myhobby.fragment.FragmentAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pagerAdapter=FragmentAdapter(supportFragmentManager)
        val pager:ViewPager=findViewById(R.id.viewPager)
        pager.adapter=pagerAdapter


        val navigation = findViewById<BottomNavigationView>(R.id.bottomNavigation_subjects)

        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                // 네비게이션 메뉴 아이템 체크상태
                navigation.menu.getItem(position).isChecked = true
            }
        })

        navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                // itemId에 따라 viewPager 바뀜
                R.id.menuitem_1 -> pager.currentItem = 0
                R.id.menuitem_2 -> pager.currentItem = 1
                R.id.menuitem_3 -> pager.currentItem = 2
                R.id.menuitem_4 -> pager.currentItem = 3
            }
            true
        }

    }
}