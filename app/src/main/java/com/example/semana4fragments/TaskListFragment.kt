package com.example.semana4fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.semana4fragments.databinding.FragmentTaskListBinding
import java.util.*

class TaskListFragment : Fragment(), NewTaskFragment.OnNewTaskListener {

    private var _binding:FragmentTaskListBinding? = null
    private val binding get() = _binding!!

    // STATE
    private val adapter = TasksAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTaskListBinding.inflate(inflater, container, false)
        val view = binding.root

        // Recrear el estado
        val tasksRecycler = binding.taskRecycler
        tasksRecycler.setHasFixedSize(true)
        tasksRecycler.layoutManager = LinearLayoutManager(activity)
        tasksRecycler.adapter = adapter

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        @JvmStatic
        fun newInstance() = TaskListFragment()

    }

    //Método que se ejecuta desde el NewTaskFragment
    override fun onNewTask(task: String) {
        //Modificar el estado
        val newTask = Task(UUID.randomUUID().toString(), task)
        adapter.addTask(newTask)
    }
}