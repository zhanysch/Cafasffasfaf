package com.example.sambo.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.sambo.R
import com.example.sambo.SecondActivity
import com.example.sambo.onBoard.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({selectActivity()},3000)
    }

    private fun selectActivity(){
        if (PreferenceHelper.getIsFirtstLaunch()){
            startActivity(Intent(applicationContext, MainActivity:: class.java))
            finish()
        }
        else {
            startActivity(Intent(this, SecondActivity::class.java))
            finish()
        }
    }
}
