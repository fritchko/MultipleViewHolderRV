package com.example.advancedrecyclertest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.advancedrecyclertest.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        val animalList = listOf<AnimalData>(
            AnimalData.Cat("McMuffins",5,"Cat"),
            AnimalData.Dog("Doctor Muffinstein",7,"Dog"),
            AnimalData.Mouse("Fastinzio",2,"Mouse"),
        )

        binding.recyclerview.adapter = AnimalAdapter(animalList)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}