package com.example.newprojectwithroomdb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.newprojectwithroomdb.databinding.FragmentNewScheduleBinding

class NewScheduleFragment : Fragment() {

    private lateinit var binding: FragmentNewScheduleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewScheduleBinding.inflate(inflater,container,false)
        return binding.root
    }


}