package edu.unikom.praktikfragmentproject

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.unikom.praktikfragmentproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        val framentA = FragmentA()
        val fragmentB = FragmentB()
        val btnA = findViewById<Button>(R.id.btn_a)
        val btnB = findViewById<Button>(R.id.btn_b)

        fragmentManager.beginTransaction()
            .add(R.id.frameContainer, framentA, framentA::class.java.simpleName)
            .commit()

       btnA.setOnClickListener {
            var fragment = fragmentManager.findFragmentByTag(FragmentA::class.java.simpleName)
            if (fragment !is FragmentA) {
                fragmentManager.beginTransaction()
                    .replace(R.id.frameContainer, framentA, framentA::class.java.simpleName)
                    .commit()}
        }
        btnB.setOnClickListener {
            var fragment = fragmentManager.findFragmentByTag(FragmentB::class.java.simpleName)
            if (fragment !is FragmentB) {
                fragmentManager.beginTransaction()
                    .replace(R.id.frameContainer, fragmentB, fragmentB::class.java.simpleName)
                    .commit()
            }
        }

    }
}