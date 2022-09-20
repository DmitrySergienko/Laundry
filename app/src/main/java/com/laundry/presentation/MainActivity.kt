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
import androidx.room.Room
import com.laundry.R
import com.laundry.data.database.CategoryDatabase
import com.laundry.data.database.entities.CategoryEntity
import com.laundry.databinding.ActivityMainBinding
import com.laundry.domain.Category
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

        //database room
        val db = Room.databaseBuilder(
            applicationContext,
            CategoryDatabase::class.java,"main_order"
        ).build()

        val dao = db.getCategoryDao()


        var  list = listOf<CategoryEntity>(
            CategoryEntity(0,false,R.drawable.ic_checkbox_image_one,"Shorts",3),
            CategoryEntity(1,false,R.drawable.ic_checkbox_image_two,"Cardigan",2),
            CategoryEntity(2,false,R.drawable.ic_checkbox_image_three,"Skirt",3),
            CategoryEntity(3,false,R.drawable.ic_checkbox_t_shirt,"T-Shirt",3),
            CategoryEntity(4,false,R.drawable.ic_checkbox_other,"Other",3),
            CategoryEntity(5,false,R.drawable.ic_checkbox_image_one,"Shorts",3),

        )

        Executors.newSingleThreadExecutor().execute{
            dao.insertCategory(list) //вносим в бд данные
            println("VVV ${dao.getAll()}") // читаем из бд
        }
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