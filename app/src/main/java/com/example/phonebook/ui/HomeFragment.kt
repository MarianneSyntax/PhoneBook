package com.example.phonebook.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.phonebook.R
import com.example.phonebook.data.model.Contact
import com.example.phonebook.databinding.FragmentHomeBinding
import com.example.phonebook.ui.adapter.ContactAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val contactAdapter = ContactAdapter()
        binding.recyclerView.adapter = contactAdapter

        // contacts variable aus dem viewModel observen, bei Veränderungen contacts neu in den Adapter schreiben
        viewModel.contacts.observe(viewLifecycleOwner) {
            contactAdapter.submitList(it)
        }

        // Button fügt einen Listeneintrag hinzu
        binding.btnAdd.setOnClickListener {
            val name = binding.inName.text.toString()
            val number = binding.inPhoneNumber.text.toString()

            if (name != "" && number != "") {
                val newContact = Contact(name = name, number = number)
                viewModel.insertContact(newContact)

                binding.inName.setText("")
                binding.inPhoneNumber.setText("")
            } else {
                Toast.makeText(requireContext(), "please try again", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}