package com.example.semana4fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TasksAdapter : RecyclerView.Adapter<TaskViewHolder>() {
    private val tasks = ArrayList<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        // Inflate
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.taskrow, parent, false)
        val taskViewHolder = TaskViewHolder(view)
        return taskViewHolder
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val taskn = tasks[position]
        holder.tasktextrow.text = taskn.task
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    fun addTask(task: Task){
        tasks.add(task)
        // En este caso no se tiene que hacer el notify
        // Se hace cuando el recycler se está viendo y se debe renderizar nuevamente
    }

}