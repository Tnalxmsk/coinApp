package com.example.cocoin.view.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.cocoin.databinding.ActivityIntroBinding
import com.example.cocoin.view.MainActivity

class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding
    private val viewModel : IntroViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            viewModel.checkFirstFlag()
            viewModel.first.observe(this@IntroActivity) {
                if (it) {
                    // 처음 접속 유저 x
                    val intent = Intent(this@IntroActivity, MainActivity::class.java)
                    startActivity(intent)
                }
                else {
                    // 처음 접속 유저
                }
            }
        }
    }
}