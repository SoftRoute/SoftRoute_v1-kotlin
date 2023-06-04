package com.example.softroute_v1.controller.fragments.admin

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.service.ConsigneeApiService
import com.example.softroute_v1.controller.retrofitApiConsume.Constants.Constants
import com.example.softroute_v1.controller.retrofitApiConsume.Sender.model.Sender
import com.example.softroute_v1.controller.retrofitApiConsume.Sender.service.SenderApiService
import com.example.softroute_v1.databinding.FragmentAdminEditConsigneeBinding
import com.example.softroute_v1.databinding.FragmentAdminEditSenderBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AdminEditSenderFragment : Fragment() {

    private var _binding: FragmentAdminEditSenderBinding? = null
    private val binding get() = _binding!!

    private val args:AdminEditSenderFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentAdminEditSenderBinding.inflate(inflater,container,false)
        val view=binding.root

        val sender: Sender =args.sender

        val idSender=sender.id
        val inputName=binding.textInputEditName
        val inputEmail=binding.textInputEditEmail

        inputName.setText(Editable.Factory.getInstance().newEditable(sender.name))
        inputEmail.setText(Editable.Factory.getInstance().newEditable(sender.email))


        binding.btnModifyInformationSender.setOnClickListener {

            if(validateFields()){
                updateDataToBackend(idSender)
                val action=AdminEditSenderFragmentDirections.actionAdminEditSenderFragmentToAdminSendersListFragment()
                findNavController().navigate(action)
            }else{
                Toast.makeText(requireContext(), "Please fill in all the required fields", Toast.LENGTH_SHORT).show()
            }
        }

        return  view

    }

    private fun validateFields():Boolean{

        val inputName=binding.textInputEditName
        val inputEmail=binding.textInputEditEmail

        var isValid=true

        if(TextUtils.isEmpty(inputName.text)){
            inputName.error="Name is required"
            isValid=false
        }else{
            inputName.error=null
        }

        if (TextUtils.isEmpty(inputEmail.text)) {
            inputEmail.error = "Email is required"
            isValid = false
        } else if (!inputEmail.text.toString().contains("@")) {
            inputEmail.error = "Invalid email format"
            isValid = false
        } else {
            inputEmail.error = null
        }

        return isValid
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun updateDataToBackend(id:Int){
        val inputName=binding.textInputEditName
        val inputEmail=binding.textInputEditEmail
        val modifyName=inputName.text.toString()
        val modifiEmail=inputEmail.text.toString()

        val modifySender=Sender(id,modifyName,modifiEmail)

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL) // Reemplaza con la URL base de tu API
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(SenderApiService::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = apiService.updateSender(id.toString(), modifySender)
                if (response.isSuccessful) {
                    // El Sender se actualizó correctamente
                    activity?.runOnUiThread {
                        Toast.makeText(requireContext(), "Sender updated successfully", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Error al actualizar el Sender
                    activity?.runOnUiThread {
                        Toast.makeText(requireContext(), "Failed to update sender", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                // Error de conexión u otro error
                activity?.runOnUiThread {
                    Toast.makeText(requireContext(), "An error occurred: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}