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

//            setFragmentResult(RESULT_REQUEST_KEY, bundleOf(RESULT_KEY to data))
            App.db.taskDao().insert(data)
            findNavController().navigateUp()
        }
    }

    companion object{
        const val RESULT_REQUEST_KEY = "request.key"
        const val RESULT_KEY = "result.key"
    }


}