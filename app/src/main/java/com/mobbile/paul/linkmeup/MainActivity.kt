package com.mobbile.paul.linkmeup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobbile.paul.linkmeup.fragment.mainfragment.MainFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //using navigation Component
    fun showFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MainFragment(), "Fragment")
            .commit()
    }

}




