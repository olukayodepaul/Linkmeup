package com.mobbile.paul.linkmeup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mobbile.paul.linkmeup.fragment.HomeFragment
import com.mobbile.paul.linkmeup.fragment.QrFragment
import com.mobbile.paul.linkmeup.fragment.VideoFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
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

interface Api{
    fun myApiModel(): MyApiModel
}

class ImplementApi: Api{
    override fun myApiModel(): MyApiModel {
        return MyApiModel()
    }
}

class MyApiModel


@Module
@InstallIn(ApplicationComponent::class)
class ProvideInteface{

    @Provides
    @Singleton
    fun provideApi(): Api{
        return ImplementApi()
    }

}


