package com.example.homework3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.view.children
import androidx.core.view.forEach
import com.example.homework3.databinding.FragmentTask1Binding
import com.example.homework3.databinding.FragmentTask2Binding

class Task1 : Fragment() {
    private var _binding: FragmentTask1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val anim = AnimationUtils.loadAnimation(activity, R.anim.zoom_in)
        _binding = FragmentTask1Binding.inflate(inflater, container, false)

        binding.root.children.forEach { view ->
            view.setOnClickListener {
                view.startAnimation(anim)
                Toast.makeText(activity, "${view.contentDescription}", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}