package com.example.softroute_v1.controller.fragments.client

import android.os.Bundle
import android.text.Layout
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.client.API.ApiRequest
import com.example.softroute_v1.controller.client.API.Shipment
import com.example.softroute_v1.controller.client.shipments.util.Constants.Companion.BASE_URL
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientTrackingFragment : Fragment() {
    private lateinit var shipmentData: Shipment
    private lateinit var code: TextView
    private lateinit var dateReception: TextView
    private lateinit var shipmentCardLayout: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_client_tracking, container, false)

        shipmentCardLayout = view.findViewById(R.id.cardShipment)
        shipmentCardLayout.visibility = View.GONE // Oculta la carta al inicio

        val searchButton = view.findViewById<Button>(R.id.next)
        val trackingCodeInput = view.findViewById<AppCompatEditText>(R.id.input_user_code_tracking)

        code = view.findViewById(R.id.codeShipmentContent)
        dateReception = view.findViewById(R.id.receptionDateContent)

        searchButton.setOnClickListener {
            val trackingCode = trackingCodeInput.text?.toString()
            if (!trackingCode.isNullOrEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {

                    try {
                        val shipmentList = makeApiRequest(trackingCode)
                        withContext(Dispatchers.Main) {
                            if (shipmentList.isNotEmpty()) {
                                shipmentData = shipmentList[0]
                                updateShipmentCard()
                                shipmentCardLayout.visibility = View.VISIBLE
                                Toast.makeText(requireContext(), "Código de seguimiento: $trackingCode", Toast.LENGTH_SHORT).show()
                            }else{
                                shipmentCardLayout.visibility = View.INVISIBLE
                                Toast.makeText(requireContext(), "No se ha encontrado un codigo de tracking como el siguiente: $trackingCode", Toast.LENGTH_SHORT).show()
                            }
                        }
                    } catch (e: Exception) {
                        Log.e("ClientTrackingFragment", "Error en la solicitud de la API: ${e.message}", e)
                    }

                }
            }
        }

        return view
    }

    private suspend fun makeApiRequest(query: String): List<Shipment> {
        return try {
            val api = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiRequest::class.java)

            api.getShipmentById(query)
        } catch (e: Exception) {
            Log.e("ClientTrackingFragment", "Error en la solicitud de la API: ${e.message}", e)
            emptyList()
        }
    }


    private fun updateShipmentCard() {
        if (::shipmentData.isInitialized) {
            code.text = shipmentData.id.toString()
            dateReception.text = shipmentData.date
            // Actualizar otras vistas de texto según sea necesario
            // ...
        }
    }
}
