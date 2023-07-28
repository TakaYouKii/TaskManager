package com.example.taskmanager.ui.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.taskmanager.App
import com.example.taskmanager.R
import com.example.taskmanager.databinding.FragmentHomeBinding
import com.example.taskmanager.model.Task
import com.example.taskmanager.ui.Task.TaskFragment.Companion.RESULT_KEY
import com.example.taskmanager.ui.Task.TaskFragment.Companion.RESULT_REQUEST_KEY
import com.example.taskmanager.ui.Task.adapter.TaskAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val adapter = TaskAdapter(this::onLongClick)

    private fun onLongClick(taskId: Int): Boolean {

        val builder = AlertDialog.Builder(this.requireContext())
        builder.setTitle("Delete")
        builder.setMessage("Are you sure about this?")
        builder.setNeutralButton("Cansel") { _, _ ->
        }
        builder.setPositiveButton("Yes") { _, _ ->
            val list = App.db.taskDao().getAll()
            val taskListItem = list[taskId]
            App.db.taskDao().delete(taskListItem)
            findNavController().navigate(R.id.navigation_home)
        }
        builder.show()
        return true
    }


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        val data = App.db.taskDao().getAll()
        adapter.addTasks(data)
        binding.fab.setOnClickListener{
            findNavController().navigate(R.id.taskFragment)
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}