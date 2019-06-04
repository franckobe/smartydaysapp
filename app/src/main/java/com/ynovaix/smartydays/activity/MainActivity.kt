package com.ynovaix.smartydays.activity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.ynovaix.smartydays.R
import com.ynovaix.smartydays.fragment.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener
{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(
            R.id.main_content,
            Item1Fragment()
        ).commit()
        navView.setCheckedItem(R.id.item1)

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.container, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragmentManager: FragmentManager = supportFragmentManager
        when (item.itemId) {
            R.id.item1 -> {
                fragmentManager.beginTransaction().replace(
                    R.id.main_content,
                    Item1Fragment()
                ).commit()
            }
            R.id.item2 -> {
                fragmentManager.beginTransaction().replace(
                    R.id.main_content,
                    Item2Fragment()
                ).commit()
            }
            R.id.item3 -> {
                fragmentManager.beginTransaction().replace(
                    R.id.main_content,
                    Item3Fragment()
                ).commit()
            }
            R.id.item4 -> {
                fragmentManager.beginTransaction().replace(
                    R.id.main_content,
                    Item4Fragment()
                ).commit()
            }
            R.id.item5 -> {
                fragmentManager.beginTransaction().replace(
                    R.id.main_content,
                    Item5Fragment()
                ).commit()
            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
