package com.example.poo.ui

import CsvParser
import com.example.poo.parsing.DataManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.poo.databinding.ActivityMainBinding
import com.example.poo.interact
import com.example.poo.parsing.Match
import com.example.poo.adapters.Adapter
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() ,interact {

    lateinit var binding: ActivityMainBinding

    private val fragments = listOf(OneFragment(), SecondFragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        parseFile()
        initRecyclerView()
//        initViewPager()
//        initTabLayout()

    }

    private fun initRecyclerView() {
        val adapter = Adapter(DataManager.matchList, this)
        binding.recycler.adapter = adapter
    }

    private fun parseFile() {
        val inputStream = assets.open("worldcup.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()
        buffer.forEachLine {
            val current = parser.parse(it)
            DataManager.addDay(current)
        }


    }

    override fun onClickItem(pray: Match) {
        TODO("Not yet implemented")
    }

    override fun onClickName(name: String) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
    }
}



/*    val tabTitle = listOf("Home", "Notification", "User")
    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab ,position ->
            tab.text = tabTitle[position]
        }.attach()
    }

    private fun initViewPager() {
        val pagerAdapter = ViewPageAdapter(this, fragments)
        binding.viewPager.adapter = pagerAdapter
    }
        */