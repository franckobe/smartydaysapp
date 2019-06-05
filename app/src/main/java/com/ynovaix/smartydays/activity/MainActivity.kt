package com.ynovaix.smartydays.activity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
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

    private lateinit var currentFragment: Fragment

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

        currentFragment = Item1Fragment()
        replaceFragment()
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

    private fun replaceFragment() {
        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(
            R.id.main_content,
            currentFragment
        ).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> {
                currentFragment = Item1Fragment()
                replaceFragment()
            }
            R.id.contactMenuItem -> {
                currentFragment = ContactFragment()
                replaceFragment()
            }
            R.id.item3 -> {
                currentFragment = Item3Fragment()
                replaceFragment()
            }
            R.id.item4 -> {
                currentFragment = Item4Fragment()
                replaceFragment()
            }
            R.id.item5 -> {
                currentFragment = Item5Fragment()
                replaceFragment()
            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putString("fragment",currentFragment.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        when (savedInstanceState?.getString("fragment")) {
            "item1_fragment" -> {
                currentFragment = Item1Fragment()
                replaceFragment()
            }
            "contact_fragment" -> {
                currentFragment = ContactFragment()
                replaceFragment()
            }
            "item3_fragment" -> {
                currentFragment = Item3Fragment()
                replaceFragment()
            }
            "item4_fragment" -> {
                currentFragment = Item4Fragment()
                replaceFragment()
            }
            "item5_fragment" -> {
                currentFragment = Item5Fragment()
                replaceFragment()
            }
        }
    }

}
