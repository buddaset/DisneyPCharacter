package com.example.disneyperson.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.commitNow
import com.example.disneyperson.R
import com.example.disneyperson.disney_characters.precentation.DisneyCharactersFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commitNow {
                add(R.id.container_fragment, DisneyCharactersFragment.newInstance())
            }
        }
    }



}