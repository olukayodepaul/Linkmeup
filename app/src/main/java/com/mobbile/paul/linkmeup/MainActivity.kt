package com.mobbile.paul.linkmeup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mobbile.paul.linkmeup.fragment.HomeFragment
import com.mobbile.paul.linkmeup.fragment.QrFragment
import com.mobbile.paul.linkmeup.fragment.VideoFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var something: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        Log.d("TAG", something.doAthing())
    }

    private fun initView() {
        replaceFragment(HomeFragment())
        nav_graph.setOnNavigationItemSelectedListener(clickMenuItem)
    }

    private val clickMenuItem = BottomNavigationView.OnNavigationItemSelectedListener {
        when(it.itemId){
            R.id.phonecall ->{
                replaceFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.mycode->{
                replaceFragment(QrFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.likemeup->{
                replaceFragment(VideoFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.view_pager, fragment)
        fragmentTransaction.commit()
    }
}


class SomeClass
@Inject
constructor(){
    fun doAthing(): String{
        return "Do a thing is injected"
    }
}



