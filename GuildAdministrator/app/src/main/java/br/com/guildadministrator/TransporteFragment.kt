package br.com.guildadministrator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class TransporteFragment : BaseFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAppBarTitle(getString(R.string.transport_app_bar_title))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_transporte, container, false)
    }
}