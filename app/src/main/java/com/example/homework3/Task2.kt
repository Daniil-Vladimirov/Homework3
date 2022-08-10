package com.example.homework3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework3.databinding.FragmentMainBinding
import com.example.homework3.databinding.FragmentTask2Binding


class Task2 : Fragment() {

    private var _binding: FragmentTask2Binding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task2, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}