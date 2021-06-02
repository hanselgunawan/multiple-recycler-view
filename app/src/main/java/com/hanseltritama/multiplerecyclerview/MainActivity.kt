package com.hanseltritama.multiplerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hanseltritama.multiplerecyclerview.adapter.HorizontalAdapter
import com.hanseltritama.multiplerecyclerview.model.Result
import com.hanseltritama.multiplerecyclerview.viewmodel.ActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val activityViewModel by lazy {
        ViewModelProvider(this).get(ActivityViewModel::class.java)
    }

    private lateinit var adapter: HorizontalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityViewModel.getCharacters()
        setupObserver()
        setupAdapter()
    }

    private fun setupObserver() {
        activityViewModel.charactersLiveData.observe(this) { response ->
            adapter.setupData(response.results as ArrayList<Result>)
        }
    }

    private fun setupAdapter() {
        adapter = HorizontalAdapter()
        my_recycler_view.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        my_recycler_view.adapter = adapter
    }
}