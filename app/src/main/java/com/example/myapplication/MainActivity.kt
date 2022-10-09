package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //var planetList = Array<String>(8, empty);

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PlanetAdapter(PlanetData.list)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)

        adapter.onItemClick = {
            val intent = Intent(this, PlanetDetailsActivity::class.java)
            intent.putExtra(PlanetDetailsActivity.KEY_PLANET_DATA, it)
            startActivity(intent)
        }
    }
}