package com.example.taskmanager.ui.Task.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanager.databinding.ItemTaskBinding
import com.example.taskmanager.model.Task

class TaskAdapter:RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private val list = arrayListOf<Task>()



    fun addTasks(tasks: List<Task>){
        list.clear()
        list.addAll(tasks)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount() = list.size


    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(list[position])
    }
    inner class TaskViewHolder(private val binding: ItemTaskBinding):ViewHolder(binding.root){
        fun bind(task: Task){
            binding.tvTitle.text = task.title
            binding.tvDesk.text = task.desk
        }
    }

}