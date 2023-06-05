package com.example.softroute_v1.controller.fragments.admin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatEditText
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.retrofitApiConsume.TypeOfPackage.model.TypeOfPackage
import com.example.softroute_v1.controller.retrofitApiConsume.Constants.Constants.Companion.BASE_URL
import com.example.softroute_v1.controller.retrofitApiConsume.Documents.service.DocumentApiService
import com.example.softroute_v1.controller.retrofitApiConsume.Shipments.model.Shipment
import com.example.softroute_v1.controller.retrofitApiConsume.Shipments.service.ShipmentsApiService
import com.example.softroute_v1.controller.retrofitApiConsume.TypeOfPackage.service.TypeOfPackageApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.w3c.dom.Text
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class AdminAddShipmentFragment : Fragment() {
    private lateinit var autoCompletedText: AutoCompleteTextView
    private lateinit var documentShipment: AutoCompleteTextView
    //private lateinit var dateShipment: DatePicker
    private lateinit var weightShipment:AppCompatEditText
    private lateinit var quantityShipment:AppCompatEditText
    private lateinit var descriptionShipment:AppCompatEditText
    private lateinit var freightShipment: AppCompatEditText
    private lateinit var nameSenderShipment:AppCompatEditText
    private lateinit var emailSenderShipment:AppCompatEditText
    private lateinit var nameConsigneeShipment:AppCompatEditText
    private lateinit var emailConsigneeShipment:AppCompatEditText
    private lateinit var dniConsigneeShipment:AppCompatEditText
    private lateinit var destinationShipment:AppCompatEditText

    private lateinit var dateShipment:AppCompatEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_admin_add_shipment, container, false)

        //TYPE PACKAGE CONFI
        autoCompletedText = view.findViewById(R.id.spinner)

        // values inside the dropdown
        val values = arrayOf("electronico", "libros", "comida")

        // create an adapter to the AutoCompleteTextView
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, values)

        // apply the adpater to the AutoCompleteTextView
        autoCompletedText.setAdapter(adapter)



        //Document Configuration
        //Document Call Api
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val ApiService= retrofit.create(DocumentApiService::class.java)
        try {
            val documents = runBlocking { ApiService.getDocuments() }


            var documentName= arrayOf<String>()
            documents.forEach{
                it.name
                documentName= documentName.plus(it.name)
            }

            documentShipment=view.findViewById(R.id.inputDocumentName)
            val documentAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line,documentName )
            documentShipment.setAdapter(documentAdapter)
        }catch (e:Exception){
            Log.d("Error",e.toString())
        }
        //Document values predefined
//        documentShipment=view.findViewById(R.id.inputDocumentName)
//        val documentValues= arrayOf("boleta","factura","otro")
//        val documentAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, documentValues)
//        documentShipment.setAdapter(documentAdapter)

        //DATE CONGFI
        //var dateChoosed: String
        //dateShipment= view.findViewById<DatePicker>(R.id.datePicker)

        // obtain current date
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        // stablish current date as init date to datepicker
        //dateShipment?.init(currentYear, currentMonth, currentDayOfMonth, null)
        // Agregar el listener para capturar la fecha seleccionada
//        dateShipment?.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
//            dateChoosed = "$dayOfMonth/${monthOfYear + 1}/$year" // Formato de fecha: dd/MM/yyyy
//        }

        //CONNECTION
        val nextButton=view.findViewById<Button>(R.id.next_add_shipment)

        weightShipment=view.findViewById(R.id.inputWeight)
        quantityShipment=view.findViewById(R.id.inputQuantity)
        descriptionShipment=view.findViewById(R.id.inputDescription)
        freightShipment=view.findViewById(R.id.inputFreight)
        nameSenderShipment=view.findViewById(R.id.inputSenderName)
        emailSenderShipment=view.findViewById(R.id.inputSenderEmail)
        nameConsigneeShipment=view.findViewById(R.id.inputConsigneeName)
        emailConsigneeShipment=view.findViewById(R.id.inputConsigneeEmail)
        dniConsigneeShipment=view.findViewById(R.id.inputConsigneeDNI)
        destinationShipment=view.findViewById(R.id.inputDestination)

        dateShipment=view.findViewById(R.id.inputDate)

        nextButton.setOnClickListener{
            // access to the value selected
            val typePackage = autoCompletedText.text.toString().toInt()
            val documentSelected=documentShipment.text.toString().toInt()
            val weightSelected=weightShipment.text.toString().toInt()
            val quantitySelected=quantityShipment.text.toString().toInt()
            val descriptionSelected=descriptionShipment.text.toString()
            val freightSelected=freightShipment.text.toString().toInt()
            val nameSenderSelected=nameSenderShipment.text.toString().toInt()
            val emailSenderSelected=emailSenderShipment.text.toString()
            val nameConsigneeSelected=nameConsigneeShipment.text.toString().toInt()
            val emailConsigneeSelected=emailConsigneeShipment.text.toString()
            val dniConsigneeSelected=dniConsigneeShipment.text.toString()
            val destinationSelected=destinationShipment.text.toString().toInt()

            val dateSelected=dateShipment.text.toString()
            // Agregar el listener para capturar la fecha seleccionada
//            dateShipment?.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
//                dateChoosed = "$dayOfMonth/${monthOfYear + 1}/$year" // Formato de fecha: dd/MM/yyyy
//            }


            val shipment = Shipment(
                id=0,
                typeOfPackageId=typePackage,
                weight=weightSelected,
                quantity=quantitySelected,
                freight=freightSelected,
                description=descriptionSelected,
                senderId=nameSenderSelected,
                consigneesId=nameConsigneeSelected,
                documentId=documentSelected,
                destinyId=destinationSelected,
                date=dateSelected
            )

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val apiService = retrofit.create(ShipmentsApiService::class.java)
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val response = apiService.createShipment(shipment)
                    if (response.isSuccessful) {
                        Toast.makeText(requireContext(), "Shipment created successfully", Toast.LENGTH_SHORT).show()
                    } else {
                        // La solicitud falló, maneja el error
                    }
                } catch (e: Exception) {
                    // Maneja cualquier excepción que ocurra durante la solicitud
                }
            }



        }

        return view
    }


//    private suspend fun makeTypePackageApiRequest(query: Shipment): List<Shipment>{
////        return try {
////            val api=Retrofit.Builder()
////                .baseUrl(BASE_URL)
////                .addConverterFactory(GsonConverterFactory.create())
////                .build()
////                .create(ShipmentsApiService::class.java)
////
////            api.createShipment(query)
////        }catch(e:Exception){
////            Log.e("AdminAddShipmentFragment","API request error ${e.message}",e)
////            emptyList()
////        }
//  }

}