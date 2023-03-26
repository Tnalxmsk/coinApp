package com.example.cocoin.view.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.cocoin.R
import com.example.cocoin.databinding.FragmentIntroOneBinding

class IntroOneFragment : Fragment() {
    private var _binding: FragmentIntroOneBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIntroOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener(view)
    }

    private fun initListener(view: View) {
        with(binding) {
            introOneNextBt.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.action_introOneFragment_to_introTwoFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}