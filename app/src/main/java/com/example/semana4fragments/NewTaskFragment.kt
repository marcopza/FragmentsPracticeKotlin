package com.example.semana4fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.semana4fragments.databinding.ActivityMainBinding
import com.example.semana4fragments.databinding.FragmentNewTaskBinding


class NewTaskFragment : Fragment() {

    private var _binding: FragmentNewTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e(">>>", "onCreateView")
        _binding = FragmentNewTaskBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        binding.addBtn.setOnClickListener {
            val text = binding.newItemET.text.toString()
            Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
        }

        return view
    }

    //Ciclo de vida
    override fun onAttach(context: Context) {
        Log.e(">>>", "onAttach")
        super.onAttach(context)
    }

    override fun onResume() {
        Log.e(">>>", "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.e(">>>", "onPause")
        super.onPause()
    }

    override fun onDetach() {
        Log.e(">>>", "onDetach")
        super.onDetach()
    }

    // Control+O
    override fun onDestroyView() {
        Log.e(">>>", "onDestroyView")
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewTaskFragment()
    }
}