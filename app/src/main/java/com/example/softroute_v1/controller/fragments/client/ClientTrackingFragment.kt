package com.example.softroute_v1.controller.fragments.client

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.service.ConsigneeApiService
import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.model.Consignee
import com.example.softroute_v1.controller.retrofitApiConsume.Deliveries.service.DeliveryApiService
import com.example.softroute_v1.controller.retrofitApiConsume.Deliveries.model.Delivery
import com.example.softroute_v1.controller.retrofitApiConsume.Shipments.service.ShipmentsApiService
import com.example.softroute_v1.controller.retrofitApiConsume.Shipments.model.Shipment
import com.example.softroute_v1.controller.retrofitApiConsume.Constants.Constants.Companion.BASE_URL
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
    private lateinit var dateReceiver: TextView
    private lateinit var deadline: TextView
    private lateinit var situation:TextView
    private lateinit var personReceive:TextView
    private lateinit var shipmentCardLayout: View



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_client_tracking, container, false)

        shipmentCardLayout = view.findViewById(R.id.cardShipment)
        shipmentCardLayout.visibility = View.GONE // Oculta la carta al inicio

        val progressBar = view.findViewById<ProgressBar>(R.id.progressBarTracking)
        progressBar.visibility = View.GONE // Oculta el ProgressBar al inicio


        val searchButton = view.findViewById<Button>(R.id.next)
        val trackingCodeInput = view.findViewById<AppCompatEditText>(R.id.input_user_code_tracking)

        code = view.findViewById(R.id.codeShipmentContent)
        dateReception = view.findViewById(R.id.receptionDateContent)
        dateReceiver=view.findViewById(R.id.sendDateContent)
        deadline=view.findViewById(R.id.receiveDateContent)
        situation=view.findViewById(R.id.situationContent)
        personReceive=view.findViewById(R.id.personReceiveShipment)

        searchButton.setOnClickListener {
            val trackingCode = trackingCodeInput.text?.toString()
            if (!trackingCode.isNullOrEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {

                    try {
                        val shipmentList = makeApiRequest(trackingCode)
                        withContext(Dispatchers.Main) {
                            shipmentCardLayout.visibility = View.INVISIBLE
                            progressBar.visibility = View.VISIBLE
                            if (shipmentList.isNotEmpty()) {
                                shipmentData = shipmentList[0]
                                val delivery=getDeliveryByShipmentId(shipmentData.id)
                                val consignee=getConsigneeById(shipmentData.consigneesId.toString())

                                Log.v("SHIPMENT","$shipmentData")
                                Log.v("Delivery","$delivery")
                                Log.v("Consignee","$consignee")


                                if (delivery != null) updateShipmentCard(delivery,consignee)

                                shipmentCardLayout.visibility = View.VISIBLE
                                Toast.makeText(requireContext(), "Código de seguimiento: $trackingCode", Toast.LENGTH_SHORT).show()
                            }else{
                                shipmentCardLayout.visibility = View.INVISIBLE
                                Toast.makeText(requireContext(), "No se ha encontrado un codigo de tracking como el siguiente: $trackingCode", Toast.LENGTH_SHORT).show()
                            }

                            progressBar.visibility = View.GONE // Oculta el ProgressBar después de la carga
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
                .create(ShipmentsApiService::class.java)

            api.getShipmentById(query)
        } catch (e: Exception) {
            Log.e("ClientTrackingFragment", "Error en la solicitud de la API: ${e.message}", e)
            emptyList()
        }
    }

    private suspend fun makeDeliveryApiRequest():List<Delivery>{
        return try{
            val api=Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DeliveryApiService::class.java)

            api.getDeliveries()
        }catch (e:Exception){
            Log.e("ClientTrackingFragment", "Error en la solicitud de la API: ${e.message}", e)
            emptyList()
        }
    }

    private suspend fun makeConsigneeApiRequest(query: String): List<Consignee> {
        return try {
            val api = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ConsigneeApiService::class.java)

            val response = api.getConsigneeById(query)// Realiza la llamada a la API y obtiene el objeto Response
            val consignees=response // Accede a la data que tiene la respuesta
            return consignees ?: emptyList()

        } catch (e: Exception) {
            Log.e("ClientTrackingFragment", "Error en la solicitud de la API: ${e.message}", e)
            emptyList()
        }
    }


    private suspend fun getConsigneeById(query: String): Consignee? {
        val consignees = makeConsigneeApiRequest(query)
        return consignees.firstOrNull() // Devuelve el primer consignee si está disponible, de lo contrario, devuelve null
    }

    private suspend fun getDeliveryByShipmentId(shipmentId: Int): Delivery? { // /{byShipmentId}
        val deliveryList = makeDeliveryApiRequest()

        // Filtrar la lista de entregas por shipmentId
        val filteredList = deliveryList.filter { it.shipmentId == shipmentId }

        // Devolver el primer elemento de la lista filtrada (o null si no se encontró ninguna coincidencia)
        return filteredList.firstOrNull()
    }


    private fun updateShipmentCard(delivery: Delivery, consignee: Consignee?) {
        if (::shipmentData.isInitialized && consignee != null) {
            // Actualizar otras vistas de texto según sea necesario
            code.text = shipmentData.id.toString()
            dateReception.text = shipmentData.date
            dateReceiver.text = shipmentData.date
            deadline.text = delivery.date
            situation.text = delivery.description
            personReceive.text = consignee.name
            // ...
        }
    }
}
