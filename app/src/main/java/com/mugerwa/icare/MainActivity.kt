package com.mugerwa.icare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.internal.NavigationMenuItemView
import com.google.android.material.navigation.NavigationBarMenu
import com.google.android.material.navigation.NavigationBarMenuView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(toolbar)

//        framelayout for holding fragments when a user clicks on an item
        val framelayout:FrameLayout=findViewById(R.id.framelayout)
        framelayout
        drawerLayout=findViewById(R.id.drawerLayout)
        val navigationView: NavigationView=findViewById(R.id.navigationView)

//        as soon as the app is opened, it will go to the main fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.framelayout,MainFragment())
            .commit()
//        as soon as the app is opened, it will go to the main fragment


        navigationView.setNavigationItemSelectedListener {
            it.isChecked=true

//      whenever someone clicks on the item get its id and send it to the main fragment
            when(it.itemId){
                    R.id.home ->{
//                        fragments
                        supportFragmentManager.beginTransaction().replace(R.id.framelayout,MainFragment()).commit()
                    }
                R.id.laptops->{
//                        fragments
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout,LaptopFragment() ).commit()
                }
                R.id.radios ->{
//                        fragments
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout,RadioFragment()).commit()
                }
//                R.id.jeans->{
////                        fragments
//                    supportFragmentManager.beginTransaction().replace(R.id.framelayout,JeansFragment()).commit()
//                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)
        }



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        drawerLayout.openDrawer(GravityCompat.START)
        return true
    }
}