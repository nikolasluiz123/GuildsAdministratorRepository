package br.com.guildadministrator

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    protected fun setAppBarTitle(title: String){
        val activity = activity as AppCompatActivity
        activity.supportActionBar!!.title = title
    }
}