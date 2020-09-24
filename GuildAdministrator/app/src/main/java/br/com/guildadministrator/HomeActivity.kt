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

        configureToolbar()
        toggleDrawer()
        initializeDefaultFragment(savedInstanceState, 0)
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
            R.id.notifications -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.home_frame_layout, NotificacoesFragment())
                    .commit()
                closeDrawer()
            }
            R.id.profile -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.home_frame_layout, PerfilFragment())
                    .commit()
                closeDrawer()
            }
        }
        return true
    }

    private fun closeDrawer() {
        if (home_container_drawer_layout.isDrawerOpen(GravityCompat.START)) {
            home_container_drawer_layout.closeDrawer(GravityCompat.START)
        }
    }

}