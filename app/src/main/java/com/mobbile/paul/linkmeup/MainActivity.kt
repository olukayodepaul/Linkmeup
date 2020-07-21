package com.mobbile.paul.linkmeup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

class conInjector
 @Inject
 constructor(private val intefaceImp: IntefaceImp){
    fun getThing(): String {
        return intefaceImp.getIntefaceObject()
    }
}

interface someInterface {
    fun getInterface(): String
    fun getIntefaceObject(): String
}

class IntefaceImp
 constructor(): someInterface{
    override fun getInterface(): String {
        return ""
    }

    override fun getIntefaceObject(): String {
        return ""
    }
}



