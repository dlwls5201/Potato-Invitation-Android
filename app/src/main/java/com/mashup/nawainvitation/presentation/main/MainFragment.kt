package com.mashup.nawainvitation.presentation.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.mashup.nawainvitation.R
import com.mashup.nawainvitation.base.BaseFragment
import com.mashup.nawainvitation.base.util.Dlog
import com.mashup.nawainvitation.databinding.FragmentMainBinding
import com.mashup.nawainvitation.presentation.main.adapter.TypePagerAdapter

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    companion object {

        const val TAG_ID = "MainFragment"

        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    private val mainViewModel by lazy {
        ViewModelProvider(requireActivity()).get((MainViewModel::class.java))
    }

    private val typePagerAdapter by lazy {
        TypePagerAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.model = mainViewModel
        binding.documents = null

        initViewPager()
        initObserver()

        mainViewModel.loadAllTypes()
        mainViewModel.loadInvitations()
    }

    private fun initViewPager() {
        with(binding.vpMain) {
            adapter = typePagerAdapter

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    Dlog.d("position : $position")
                    super.onPageSelected(position)
                    mainViewModel.setTemplateIdFromPos(position)
                }
            })
        }
    }

    private fun initObserver() {
        mainViewModel.allTypes.observe(viewLifecycleOwner, Observer { items ->
            typePagerAdapter.replaceAll(items)
        })
    }
}