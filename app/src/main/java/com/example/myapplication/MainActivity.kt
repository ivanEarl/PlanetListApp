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

//        companion object {
//            const val PLANET_LIST =
//        }

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.btnAddTodo.text = "DONE"
        //planetList = getResource().getStringArray(R.array.planet_list);

        val planetLists = mutableListOf(
            Planet("Mercury", "Living up to its name, Mercury is the fastest planet in the solar system, speeding along at about 29 miles per second and completing each orbit around the sun in just 88 Earth days. Mercury is also the smallest planet in the solar system, measuring just 3,032 miles wide at its equator."),
            Planet("Venus", "Venus is the second planet from the Sun and Earth's closest planetary neighbor. Even though Mercury is closer to the Sun, Venus is the hottest planet in our solar system. Its thick atmosphere is full of the greenhouse gas carbon dioxide, and it has clouds of sulfuric acid."),
            Planet("Earth", "Earth is an ellipsoid with a circumference of about 40,000 km. It is the densest planet in the Solar System. Of the four rocky planets, it is the largest and most massive. Earth is about eight light minutes away from the Sun and orbits it, taking a year (about 365.25 days) to complete one revolution."),
            Planet("Mars", "Mars is the fourth planet from the Sun – a dusty, cold, desert world with a very thin atmosphere. Mars is also a dynamic planet with seasons, polar ice caps, canyons, extinct volcanoes, and evidence that it was even more active in the past."),
            Planet("Jupiter", "Jupiter is covered in swirling cloud stripes. It has big storms like the Great Red Spot, which has been going for hundreds of years. Jupiter is a gas giant and doesn't have a solid surface, but it may have a solid inner core about the size of Earth. Jupiter also has rings, but they're too faint to see very well."),
            Planet("Saturn", "Saturn is the sixth planet from the Sun and the second-largest planet in our solar system. Like fellow gas giant Jupiter, Saturn is a massive ball made mostly of hydrogen and helium. Saturn is not the only planet to have rings, but none are as spectacular or as complex as Saturn's. Saturn also has dozens of moons."),
            Planet("Uranus", "Uranus is the seventh planet from the Sun, and has the third-largest diameter in our solar system. It was the first planet found with the aid of a telescope, Uranus was discovered in 1781 by astronomer William Herschel, although he originally thought it was either a comet or a star."),
            Planet("Neptune", "Neptune is very similar to Uranus. It's made of a thick soup of water, ammonia, and methane over an Earth-sized solid center. Its atmosphere is made of hydrogen, helium, and methane. The methane gives Neptune the same blue color as Uranus.")
        )

        val adapter = PlanetAdapter(planetLists)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)


        adapter.onItemClick = {
            val intent = Intent(this, PlanetDetailsActivity::class.java)
            intent.putExtra(PlanetDetailsActivity.KEY_PLANET_DATA, it)
            startActivity(intent)
        }

        //textView.setOnClickListener(OnClickListener())

//        binding.btnAddTodo.setOnClickListener{
//            val title = binding.etTodo.text.toString()
//            val todo = Todo(title, false)
//            todoList.add(todo)
//            adapter.notifyItemInserted(todoList.size - 1)
//        }
    }
}