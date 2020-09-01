package com.mashup.nawainvitation.presentation.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mashup.nawainvitation.R
import com.mashup.nawainvitation.base.BaseActivity
import com.mashup.nawainvitation.data.injection.Injection
import com.mashup.nawainvitation.databinding.ActivityMainBinding
import com.mashup.nawainvitation.presentation.dialog.LoadingDialog
import com.mashup.nawainvitation.presentation.invitationinfo.InvitationInfoFragment
import com.mashup.nawainvitation.presentation.searchlocation.api.Documents
import com.mashup.nawainvitation.presentation.searchlocation.view.InputLocationFragment
import com.mashup.nawainvitation.presentation.searchlocation.view.SearchLocationFragment
import com.mashup.nawainvitation.presentation.selectdatatime.SelectingDateTimeFragment
import com.mashup.nawainvitation.utils.AppUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main),
    MainViewModel.MainListener {

    companion object {

        private const val EXTRA_TEMPLATE_ID = "template_id"
        private const val EXTRA_TYPE_NAME = "type_name"

        fun startMainActivityWithData(context: Context, templateId: Int, typeName: String) {
            context.startActivity(
                Intent(context, MainActivity::class.java).apply {
                    putExtra(EXTRA_TEMPLATE_ID, templateId)
                    putExtra(EXTRA_TYPE_NAME, typeName)
                }
            )
        }
    }

    private val mainViewModel by lazy {
        ViewModelProvider(
            this,
            MainViewModelFactory(
                Injection.provideInvitationRepository(),
                this,
                getTemplateId(),
                getTypeName()
            )
        ).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.model = mainViewModel

        initTopBar()
        initFragment()
    }

    private fun initTopBar() {
        btnMainBack.setOnClickListener {
            AppUtils.hideSoftKeyBoard(this)
            onBackPressed()
        }
    }

    private fun initFragment() {
        goToInvitationMain()
    }

    private fun replaceFragmentWithTitle(title: String, fragment: Fragment, tag: String? = null) {
        tvMainTopBardTitle.text = title

        supportFragmentManager.beginTransaction()
            .replace(R.id.flMainContainer, fragment, tag)
            .commit()
    }

    private fun getTemplateId() = intent?.getIntExtra(EXTRA_TEMPLATE_ID, -1) ?: -1

    private fun getTypeName() = intent?.getStringExtra(EXTRA_TYPE_NAME) ?: ""

    override fun goToInvitationMain() {
        replaceFragmentWithTitle(
            getString(R.string.make_invitation),
            MainFragment.newInstance(),
            MainFragment.TAG_ID
        )
    }

    override fun goToInvitationInfo() {
        replaceFragmentWithTitle(
            getString(R.string.input_invitation),
            InvitationInfoFragment.newInstance()
        )
    }

    override fun goToInvitationDate() {
        replaceFragmentWithTitle(
            getString(R.string.input_date),
            SelectingDateTimeFragment.newInstance()
        )
    }

    override fun goToInvitationInputLocation(documents: Documents?) {
        replaceFragmentWithTitle(
            getString(R.string.input_location_title),
            InputLocationFragment.newInstance(documents)
        )
    }

    override fun goToInvitationSearchLocation() {
        replaceFragmentWithTitle(
            getString(R.string.input_location_title),
            SearchLocationFragment.newInstance()
        )
    }

    override fun goToInvitationPhoto() {
        //TODO next step
    }

    override fun goToPreview() {
        //TODO preview for share
    }

    private val loadingDialog by lazy {
        LoadingDialog(this)
    }

    override fun showLoading() {
        if (loadingDialog.isShowing) return
        loadingDialog.show()
    }

    override fun hideLoading() {
        if (loadingDialog.isShowing) {
            loadingDialog.hide()
        }
    }
}