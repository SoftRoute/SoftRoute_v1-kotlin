package com.example.softroute_v1.controller.fragments.admin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.adapter.ConsigneeAdapter
import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.service.ConsigneeApiService
import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.model.Consignee
import com.example.softroute_v1.controller.retrofitApiConsume.Constants.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AdminConsigneesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_admin_consignees, container, false)

        CoroutineScope(Dispatchers.IO).launch{
            try {
                val consigneeList = makeConsigneesApiRequest()
                withContext(Dispatchers.Main) {

                    if (consigneeList.isNotEmpty()) {

                        //Tenemos la lista , aquí entonces pintariamos toda la morisqueta
                        Log.v("PRINT",consigneeList.toString())
                        initRecyclerView(consigneeList)

                        Toast.makeText(requireContext(), "Toasst", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(requireContext(), "Toasst", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                Log.e("AdminConsigneesFragment", "Error en la solicitud de la API: ${e.message}", e)
            }
        }

        return view
    }

    private suspend fun makeConsigneesApiRequest(): List<Consignee> {
        return try {
            val api = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ConsigneeApiService::class.java)

            val consigneesResponse = api.getConsignees() // Realiza la llamada a la API y obtiene el objeto ConsigneesResponse

            if(consigneesResponse.isNotEmpty()){
                return consigneesResponse
            }

            return emptyList()
        } catch (e: Exception) {
            Log.e("AdminCosigneesFragment", "Error en la solicitud de la API: ${e.message}", e)
            emptyList()
        }
    }

    private fun initRecyclerView(listConsignee: List<Consignee>){
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerConsignees)
        recyclerView?.layoutManager=LinearLayoutManager(requireContext())
        recyclerView?.adapter=ConsigneeAdapter(listConsignee)
    }

}