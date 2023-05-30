package com.example.softroute_v1.controller.fragments.admin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.service.ConsigneeApiService
import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.model.Consignee
import com.example.softroute_v1.controller.retrofitApiConsume.Constants.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AdminConsigneesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AdminConsigneesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AdminConsigneesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AdminConsigneesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
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




}