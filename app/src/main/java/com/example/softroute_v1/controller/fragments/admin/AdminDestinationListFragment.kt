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
import com.example.softroute_v1.controller.retrofitApiConsume.Constants.Constants
import com.example.softroute_v1.controller.retrofitApiConsume.Destinations.adapter.DestinationAdapter
import com.example.softroute_v1.controller.retrofitApiConsume.Destinations.model.Destination
import com.example.softroute_v1.controller.retrofitApiConsume.Destinations.service.DestinationApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class AdminDestinationListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        CoroutineScope(Dispatchers.IO).launch{
            try {
                val destinationList=makeDestinationApiRequest()
                withContext(Dispatchers.Main){
                    if(destinationList.isNotEmpty()){
                        initRecyclerView(destinationList)
                    }else{
                        Toast.makeText(requireContext(),"Toast",Toast.LENGTH_SHORT).show()
                    }
                }
            }catch (e: Exception){
                Log.e("AdminDestinationFragment","Error request API:  ${e.message}", e)
            }
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_destination_list, container, false)
    }

    private fun initRecyclerView(destinationList: List<Destination>) {
        val recyclerView=view?.findViewById<RecyclerView>(R.id.recyclerDestination)
        recyclerView?.layoutManager=LinearLayoutManager(requireContext())
        recyclerView?.adapter=DestinationAdapter(destinationList)

//        recyclerView?.adapter=DestinationAdapter(destinationList).apply {
//
//        }

    }

    private suspend fun makeDestinationApiRequest(): List<Destination> {
        return try {
            val api=Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DestinationApiService::class.java)
            val destinationResponse=api.getDestinations()

            if (destinationResponse.isNotEmpty()){
                return destinationResponse
            }

            return emptyList()
        }catch (e:Exception){
            Log.e("AdminDestinationFragment", "Error en la solicitud de la API: ${e.message}", e)
            emptyList()
        }

    }

}