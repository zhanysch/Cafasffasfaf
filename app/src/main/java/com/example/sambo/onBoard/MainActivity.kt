package com.example.sambo.onBoard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.sambo.R
import com.example.sambo.SecondActivity
import com.example.sambo.data.DataOnBoard
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val list = arrayListOf<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewPager()
        setupListener()
    }

    private fun setupListener() {
        OnViewPager.setOnPageChangeListener(object  : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                if (checktoPage(position)){
                    btnskip.text = "Продолжить"
                } else {
                    btnskip.text = "Пропустить"
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        btnskip.setOnClickListener {
            if (checktoPage(OnViewPager.currentItem)){
                startActivity(Intent(this, SecondActivity:: class.java))
                finish()
            } else{
                OnViewPager.currentItem += 1
            }
        }
    }

    private fun checktoPage(position : Int) = position == list.size -1

    private fun setupViewPager() {
        val adapterl = OnBoardAdapter(supportFragmentManager)
        OnViewPager.adapter = adapterl
        list.add(OnBoardFragment.getInstance(DataOnBoard(R.drawable.onboard1,getString(R.string.word1))))
        list.add(OnBoardFragment.getInstance(DataOnBoard(R.drawable.onboard2,getString(R.string.word2))))
        list.add(OnBoardFragment.getInstance(DataOnBoard(R.drawable.onboard3,getString(R.string.word3))))
        adapterl.update(list)
        onTabl.setupWithViewPager(OnViewPager)

    }
}