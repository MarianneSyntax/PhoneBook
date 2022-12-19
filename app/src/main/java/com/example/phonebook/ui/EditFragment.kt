package com.example.phonebook.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.phonebook.R
import com.example.phonebook.data.model.Contact
import com.example.phonebook.databinding.FragmentEditBinding

class EditFragment: Fragment() {

    private lateinit var binding: FragmentEditBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val id = requireArguments().getLong("contactId")

        var contact: Contact? = null

        viewModel.contacts.observe(viewLifecycleOwner) { list ->
            contact = list.find { it.id == id }

            if (contact != null) {
                binding.editNameEdit.setText(contact!!.name)
                binding.editNumberEdit.setText(contact!!.number)
            }
        }

        binding.editSaveButton.setOnClickListener {
            if (contact != null) {
                contact!!.name = binding.editNameEdit.text.toString()
                contact!!.number = binding.editNumberEdit.text.toString()

                viewModel.updateContact(contact!!)
            }
            findNavController()
                .navigateUp()
        }

        binding.editDeleteButton.setOnClickListener {
            if (contact != null) {
                viewModel.deleteContact(contact!!)
            }
            findNavController()
                .navigateUp()
        }
    }


}