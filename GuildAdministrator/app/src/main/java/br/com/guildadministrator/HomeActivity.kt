package br.com.guildadministrator

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        replaceHomeFragment()
        configureToolbar()
        toggleDrawer()
        initializeDefaultFragment(savedInstanceState, 0)
    }

    private fun replaceHomeFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.home_frame_layout, HomeFragment())
            .commit()
    }

    private fun configureToolbar() {
        setSupportActionBar(home_toolbar)
        home_navigation_view.setNavigationItemSelectedListener(this)
    }

    private fun initializeDefaultFragment(savedInstanceState: Bundle?, itemIndex: Int) {
        if (savedInstanceState == null) {
            val menuItem = home_navigation_view.menu.getItem(itemIndex).setChecked(true)
            onNavigationItemSelected(menuItem)
        }
    }

    private fun toggleDrawer() {
        val drawerToggle = ActionBarDrawerToggle(
            this, home_container_drawer_layout, home_toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        home_container_drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }

    override fun onBackPressed() {
        if (home_container_drawer_layout.isDrawerOpen(GravityCompat.START)) {
            home_container_drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                replaceHomeFragment()
                closeDrawer()
            }
            R.id.notifications -> {
                replaceNotificationsFragment()
                closeDrawer()
            }
            R.id.profile -> {
                replaceProfileFragment()
                closeDrawer()
            }
        }
        return true
    }

    private fun replaceProfileFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.home_frame_layout, PerfilFragment())
            .commit()
    }

    private fun replaceNotificationsFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.home_frame_layout, TransporteFragment())
            .commit()
    }

    private fun closeDrawer() {
        if (home_container_drawer_layout.isDrawerOpen(GravityCompat.START)) {
            home_container_drawer_layout.closeDrawer(GravityCompat.START)
        }
    }

}