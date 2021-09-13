package com.example.semana4fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.semana4fragments.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


    private lateinit var newTaskFragment: NewTaskFragment
    private lateinit var taskListFragment: TaskListFragment
    private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        newTaskFragment = NewTaskFragment.newInstance()

        taskListFragment = TaskListFragment.newInstance()

        //Suscripción
        newTaskFragment.listener = taskListFragment

        showFragment(newTaskFragment)

        binding.navigator.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.newitem -> {
                    showFragment(newTaskFragment)
                }
                R.id.listitem -> {
                    showFragment(taskListFragment)
                }
            }
            true
        }

    }

    private fun showFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }

}