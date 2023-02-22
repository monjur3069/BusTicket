package com.example.newprojectwithroomdb

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.newprojectwithroomdb.customdialogs.DatePickerFragment
import com.example.newprojectwithroomdb.customdialogs.TimePickerFragment
import com.example.newprojectwithroomdb.databinding.FragmentNewScheduleBinding

class NewScheduleFragment : Fragment() {

    private lateinit var binding: FragmentNewScheduleBinding

    private var from = "Dhaka"
    private var to = "Dhaka"
    private var busType = busTypeEconomy
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewScheduleBinding.inflate(inflater,container,false)
        initSpinner()
        initBusTypeRadioGroup()
        binding.dateBtn.setOnClickListener {
            DatePickerFragment {
                binding.showDateTV.text = it
            }.show(childFragmentManager,null)
        }
        binding.timeBtn.setOnClickListener {
            TimePickerFragment{
                binding.showTimeTV.text = it
            }.show(childFragmentManager,null)
        }

        binding.saveBtn.setOnClickListener {
            saveInfo()
        }
        return binding.root
    }

    private fun saveInfo() {
        val name = binding.busNameInputET.text.toString()
        val date = binding.showDateTV.text.toString()
        val time = binding.showTimeTV.text.toString()
        //TODO: validate name, date, time
        if(from == to){
            Toast.makeText(
                requireActivity(),
                "Origin and destination cannot be same",
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        val schedule = BusSchedule(
            id = System.currentTimeMillis(),
            busName = name,
            busType = busType,
            departureDate = date,
            departureTime = time,
            from = from,
            to = to
        )
        scheduleList.add(schedule)
        findNavController().navigate(R.id.action_newScheduleFragment_to_scheduleListFragment)
        Log.d("NewScheduleFragment","saveInfo: $schedule")
        Toast.makeText(requireActivity(), "$schedule", Toast.LENGTH_SHORT).show()
    }

    private fun initBusTypeRadioGroup() {
        binding.busTypeRG.setOnCheckedChangeListener { radioGroup, i ->
            val rb: RadioButton = radioGroup.findViewById(i)
            busType = rb.text.toString()
        }
    }

    private fun initSpinner() {
        val adapter = ArrayAdapter<String>(
            requireActivity(),
            android.R.layout.simple_spinner_dropdown_item,
            cityList
        )
        binding.citySpinnerFrom.adapter = adapter
        binding.citySpinnerTo.adapter = adapter

        binding.citySpinnerFrom.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                from = p0?.getItemAtPosition(p2).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        binding.citySpinnerTo.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                to = p0?.getItemAtPosition(p2).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

}