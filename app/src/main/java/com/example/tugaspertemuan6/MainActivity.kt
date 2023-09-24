package com.example.tugaspertemuan6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.tugaspertemuan6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val category = arrayOf(
            "Economy",
            "Premium Economy",
            "Business",
            "First Class"
        )

        val cities = resources.getStringArray(R.array.cities)
        val countries = resources.getStringArray(R.array.countries)
        val passengers = resources.getStringArray(R.array.passengers)

        with(binding) {
            val categoryAdapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_dropdown_item, category)
            categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinCategory.adapter = categoryAdapter

            val citiesAdapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_dropdown_item, cities)
            citiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinCities.adapter = citiesAdapter

            val countriesAdapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_dropdown_item, countries)
            countriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinCountries.adapter = countriesAdapter

            val passengersAdapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_dropdown_item, passengers)
            passengersAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinPassengers.adapter = passengersAdapter

            datePicker.init(datePicker.year, datePicker.month, datePicker.dayOfMonth) { _, year, month, day ->
                val selectedDate = "$day/${month + 1}/$year"
                Toast.makeText(this@MainActivity, selectedDate, Toast.LENGTH_SHORT).show()
            }

            timePicker.setOnTimeChangedListener { _, hourOfDay, minutes ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minutes)
                Toast.makeText(this@MainActivity, selectedTime, Toast.LENGTH_SHORT).show()
            }

            buttonCari.setOnClickListener {
                val day = datePicker.dayOfMonth
                val month = datePicker.month + 1
                val year = datePicker.year

                val hourOfDay = timePicker.hour
                val minutes = timePicker.minute
                val toastMessage = "Tiket Pesawat Pada Tanggal ${day}/${month}/${year}, Waktu ${String.format("%02d:%02d", hourOfDay, minutes)} Berhasil Dipesan"

                Toast.makeText(this@MainActivity, toastMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
