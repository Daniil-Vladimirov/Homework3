package com.example.homework3

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.homework3.databinding.FragmentTask2Binding
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class Task2 : Fragment() {

    private var _binding: FragmentTask2Binding? = null
    private val binding get() = _binding!!

    private val executor: ExecutorService = Executors.newSingleThreadExecutor()
    private val handler = Handler(Looper.getMainLooper())
    private var image: Bitmap? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTask2Binding.inflate(inflater, container, false)
        val imageView = binding.imageSearched

        binding.btnSearch.setOnClickListener {
            searchImage(imageView)
        }
        return binding.root
    }

    private fun searchImage(imageView: ImageView) {
        executor.execute {
            val link = binding.edTextLink.text.toString()
            try {
                val `in` = java.net.URL(link).openStream()
                image = BitmapFactory.decodeStream(`in`)

                handler.post {
                    imageView.setImageBitmap(image)
                }
            }

            // If the URL doesnot point to
            // image or any other kind of failure
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}