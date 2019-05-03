package com.example.examenlabo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity(), FragmentoEstatico.OnSelectOption {

    //YA MORI

    override fun onAction(id: Int) {
        var content = when (id) {
            1 -> {
                "Hola, se supone que esto debe cambiar de color"
            }
            2 -> {
                "Hola, se que esto no funciono, pero al menos es un evento"
            }
            else -> {
                "Fuck!"
            }
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_content, ContentFragment.newInstance(content))
            .addToBackStack("Co")
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var barFragment = FragmentoEstatico.newInstace(
            "Prev",
            "Next"
        )
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_bar, barFragment)
                .commit()
        }
    }
}

