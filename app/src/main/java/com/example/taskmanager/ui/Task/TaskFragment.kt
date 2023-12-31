package com.example.taskmanager.ui.Task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.taskmanager.App
import com.example.taskmanager.R
import com.example.taskmanager.databinding.ActivityMainBinding
import com.example.taskmanager.databinding.FragmentTaskkBinding
import com.example.taskmanager.model.Task

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskkBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskkBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener{
            val data = Task(
                title = binding.etTitle.text.toString().trim(),
                desk = binding.etDescription.text.toString().trim(),
            )
            if(data.title?.isEmpty() == true){
                binding.etTitle.error = "Поле Title пустое!"
            }
            else if(data.desk?.isEmpty() == true){
                binding.etDescription.error = "Поле Description пустое!"
            }
            else{
                App.db.taskDao().insert(data)
                findNavController().navigateUp()
            }

        }
    }
}