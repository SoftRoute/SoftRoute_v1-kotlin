package com.example.softroute_v1.controller.fragments.admin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.adapter.ConsigneeAdapter
import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.model.Consignee
import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.service.ConsigneeApiService
import com.example.softroute_v1.controller.retrofitApiConsume.Constants.Constants
import com.example.softroute_v1.controller.retrofitApiConsume.Sender.adapter.SenderAdapter
import com.example.softroute_v1.controller.retrofitApiConsume.Sender.model.Sender
import com.example.softroute_v1.controller.retrofitApiConsume.Sender.service.SenderApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AdminSendersListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_admin_senders_list, container, false)

        CoroutineScope(Dispatchers.IO).launch{
            try {
                val sendersList = makeSendersApiRequest()
                withContext(Dispatchers.Main) {
                    if (sendersList.isNotEmpty()) {
                        initRecyclerView(sendersList)
                    }else{
                        Toast.makeText(requireContext(), "Toasst", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                Log.e("AdminSenderFragment", "Error en la solicitud de la API: ${e.message}", e)
            }
        }
        return view
    }

    private suspend fun makeSendersApiRequest(): List<Sender> {
        return try {
            val api = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SenderApiService::class.java)

            val senderResponse = api.getSenders()// Realiza la llamada a la API y obtiene el objeto ConsigneesResponse

            Log.v("respuesta","$senderResponse")
            if(senderResponse.isNotEmpty()){
                return senderResponse
            }

            return emptyList()
        } catch (e: Exception) {
            Log.e("AdminSendersFragment", "Error en la solicitud de la API: ${e.message}", e)
            emptyList()
        }
    }

    private fun initRecyclerView(listSender: List<Sender>){
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerSenders)
        recyclerView?.layoutManager= LinearLayoutManager(requireContext())
        recyclerView?.adapter= SenderAdapter(listSender)

/*        recyclerView?.adapter = ConsigneeAdapter(listConsignee).apply {
            onButtonClick = { consignee ->
                navigateToEditConsigneeFragment(consignee)
            }
        }*/
    }

}