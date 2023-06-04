package com.example.softroute_v1.controller.fragments.admin

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.model.Consignee
import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.service.ConsigneeApiService
import com.example.softroute_v1.controller.retrofitApiConsume.Constants.Constants.Companion.BASE_URL
import com.example.softroute_v1.databinding.FragmentAdminEditConsigneeBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class AdminEditConsigneeFragment : Fragment() {

    private var _binding: FragmentAdminEditConsigneeBinding? = null
    private val binding get() = _binding!!

    private val args: AdminEditConsigneeFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentAdminEditConsigneeBinding.inflate(inflater,container,false)
        val view=binding.root

        val consignee: Consignee = args.consignee

        val idConsignee=consignee.id
        val tvDni = binding.textInputEditDNI
        val tvName = binding.textInputEditName
        val tvAddress = binding.textInputEditAddress

        //tvId.text = consignee.id.toString()

        tvDni.setText(Editable.Factory.getInstance().newEditable(consignee.dni))
        tvName.setText(Editable.Factory.getInstance().newEditable(consignee.name))
        tvAddress.setText(Editable.Factory.getInstance().newEditable(consignee.address))

        binding.btnModifyInformationConsignee.setOnClickListener {
            if (validateFields()) {
                // Todos los campos son válidos, enviar la información al backend
                updateDataToBackend(idConsignee)
                val action=AdminEditConsigneeFragmentDirections.actionAdminEditConsigneeFragmentToAdminConsigneesFragment()
                findNavController().navigate(action)
            } else {
                // Al menos uno de los campos es inválido, mostrar un mensaje de error
                Toast.makeText(requireContext(), "Please fill in all the required fields", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    private fun validateFields(): Boolean {
        val tvDni = binding.textInputEditDNI
        val tvName = binding.textInputEditName
        val tvAddress = binding.textInputEditAddress

        var isValid = true

        if (TextUtils.isEmpty(tvDni.text)) {
            tvDni.error = "DNI is required"
            isValid = false
        } else {
            tvDni.error = null
        }

        if(tvDni.text.toString().length!=8){
            tvDni.error="DNI is not valid"
            isValid=false
        }

        if (TextUtils.isEmpty(tvName.text)) {
            tvName.error = "Name is required"
            isValid = false
        } else {
            tvName.error = null
        }

        if (TextUtils.isEmpty(tvAddress.text)) {
            tvAddress.error = "Address is required"
            isValid = false
        } else {
            tvAddress.error = null
        }

        return isValid
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun updateDataToBackend(id:Int) {

        val tvDni = binding.textInputEditDNI
        val tvName = binding.textInputEditName
        val tvAddress = binding.textInputEditAddress
        val modifyDNI = tvDni.text.toString()
        val modifyName = tvName.text.toString()
        val modifyAddress = tvAddress.text.toString()

        val modifyConsignee= Consignee(id,modifyDNI,modifyAddress,modifyName)


        // Crear el objeto Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL) // Reemplaza con la URL base de tu API
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        // Crear la instancia del servicio API
        val apiService = retrofit.create(ConsigneeApiService::class.java)

        // Realizar la solicitud PUT
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = apiService.updateConsignee(id.toString(), modifyConsignee)
                if (response.isSuccessful) {
                    // El consignee se actualizó correctamente
                    activity?.runOnUiThread {
                        Toast.makeText(requireContext(), "Consignee updated successfully", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Error al actualizar el consignee
                    activity?.runOnUiThread {
                        Toast.makeText(requireContext(), "Failed to update consignee", Toast.LENGTH_SHORT).show()
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