package com.laundry.presentation

import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AnticipateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.laundry.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.Executors

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Hide the status bar
        statusbarhide()

        //Splash Screen launch
        splashScreenLaunch()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    private fun statusbarhide(){
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        // If the Android version is lower than Jellybean, use this call to hide
        // the status bar.
        if (Build.VERSION.SDK_INT < 16) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)}
    }

    private fun splashScreenLaunch() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val splashScreen = installSplashScreen()

            splashScreen.setKeepOnScreenCondition { true }
            Executors.newSingleThreadExecutor().execute {
                Thread.sleep(0)
                splashScreen.setKeepOnScreenCondition { false }
            }
            splashScreen.setOnExitAnimationListener { splashScreenProvider ->
                ObjectAnimator.ofFloat(
                    splashScreenProvider.view,
                    View.TRANSLATION_Y,
                    0f, -splashScreenProvider.view.height.toFloat()
                ).apply {
                    duration = 500
                    interpolator = AnticipateInterpolator() //with acceleration
                    doOnEnd { splashScreenProvider.remove() }
                }.start()
            }
        }
    }
}