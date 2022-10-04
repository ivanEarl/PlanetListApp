package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.databinding.ActivityPlanetDetailsBinding

class PlanetDetailsActivity : AppCompatActivity() {

    companion object{
        const val KEY_PLANET_DATA = "planet"
    }

    private lateinit var binding: ActivityPlanetDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanetDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val planet = intent.getParcelableExtra<Planet>(KEY_PLANET_DATA)
        if (planet != null) {
            val planetName: TextView = binding.tvPlanetName
            planetName.text = planet.name

            val planetDetails: TextView = binding.tvPlanetDetail
            planetDetails.text = planet.details
        }
    }
}