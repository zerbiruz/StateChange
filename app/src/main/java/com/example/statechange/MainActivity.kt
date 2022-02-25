package com.example.statechange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.statechange.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var person: Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val userText = binding.editText.text
        person = Person(userText.toString())
//        outState.putCharSequence("savedText", userText)
        outState.putParcelable("savedPerson", person)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
//        val userText = savedInstanceState.getCharSequence("savedText")
        person = savedInstanceState.getParcelable<Person>("savedPerson")!!

        binding.editText.setText(person.Name)
    }
}