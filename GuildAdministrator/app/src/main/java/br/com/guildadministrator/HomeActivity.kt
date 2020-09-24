package br.com.guildadministrator

import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var toolbar: Toolbar? = null
    private var drawerLayout: DrawerLayout? = null
    private var frameLayout: FrameLayout? = null
    private var navigationView: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initializeViews()
        toggleDrawer()
        initializeDefaultFragment(savedInstanceState, 0)
    }

    private fun initializeViews() {
        toolbar = findViewById(R.id.toolbar_id)
        toolbar!!.setTitle(R.string.toolbar_title)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.drawer_layout_id)
        frameLayout = findViewById(R.id.framelayout_id)
        navigationView = findViewById(R.id.navigationview_id)
        navigationView!!.setNavigationItemSelectedListener(this)
    }

    private fun initializeDefaultFragment(savedInstanceState: Bundle?, itemIndex: Int) {
        if (savedInstanceState == null) {
            val menuItem = navigationView!!.menu.getItem(itemIndex).setChecked(true)
            onNavigationItemSelected(menuItem)
        }
    }

    private fun toggleDrawer() {
        val drawerToggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout!!.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }

    override fun onBackPressed() {
        if (drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            drawerLayout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.notifications -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framelayout_id, NotificacoesFragment())
                    .commit()
                closeDrawer()
            }
        }
        return true
    }

    private fun closeDrawer() {
        if (drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            drawerLayout!!.closeDrawer(GravityCompat.START)
        }
    }

}