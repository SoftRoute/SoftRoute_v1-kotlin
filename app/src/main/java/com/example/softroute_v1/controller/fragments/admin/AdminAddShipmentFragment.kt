package com.example.softroute_v1.controller.fragments.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Model.Consignee
import com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Model.Destination
import com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Model.Document
import com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Model.Sender
import com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Model.Shipment
import com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Model.TypeOfPackage
import com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Service.ConsigneeApiService
import com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Service.DestinationApiService
import com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Service.DocumentApiService
import com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Service.SenderApiService
import com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Service.ShipmentApiService
import com.example.softroute_v1.controller.retrofitApiConsume.Shipment.Service.TypeOfPackegeApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AdminAddShipmentFragment : Fragment() {

    private lateinit var retrofit: Retrofit
    private lateinit var shipmentApiService: ShipmentApiService
    private lateinit var destinoApiService: DestinationApiService
    private lateinit var consignatarioApiService: ConsigneeApiService
    private lateinit var remitenteApiService: SenderApiService
    private lateinit var tipoDePaqueteApiService: TypeOfPackegeApiService
    private lateinit var documentoApiService: DocumentApiService

    private lateinit var destinoSpinner: Spinner
    private lateinit var consigneesSpinner: Spinner
    private lateinit var senderSpinner: Spinner
    private lateinit var typeOfPackageSpinner: Spinner
    private lateinit var documentSpinner: Spinner

    private lateinit var idEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var quantityEditText: EditText


    var destinoId : Int = 0
    var consignatarioId : Int = 0
    var remitenteId : Int = 0
    var tipoDePaqueteId : Int = 0
    var documentId : Int = 0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_admin_add_shipment, container, false)
        destinoSpinner = view.findViewById(R.id.destination_spinner)

        consigneesSpinner = view.findViewById(R.id.consignatario_spinner)
        senderSpinner = view.findViewById(R.id.remitente_spinner)
        typeOfPackageSpinner = view.findViewById(R.id.tipopaquete_spinner)
        documentSpinner = view.findViewById(R.id.documento_spinner)

        //idEditText = view.findViewById(R.id.id_shipment_edit_text)
        descriptionEditText = view.findViewById(R.id.description_edit_text)
        quantityEditText = view.findViewById(R.id.quantity_edit_text)

        // Configurar Retrofit
        retrofit = Retrofit.Builder()
            .baseUrl("http://20.150.216.134:7070/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        shipmentApiService = retrofit.create(ShipmentApiService::class.java)
        destinoApiService = retrofit.create(DestinationApiService::class.java)
        consignatarioApiService = retrofit.create(ConsigneeApiService::class.java)
        remitenteApiService = retrofit.create(SenderApiService::class.java)
        tipoDePaqueteApiService = retrofit.create(TypeOfPackegeApiService::class.java)
        documentoApiService = retrofit.create(DocumentApiService::class.java)

        // Cargar la lista de destinos en el Spinner
        loadDestinos()
        loadRemitente()
        loadConsignatario()
        loadTipoPaquete()
        loadDocumento()

        val saveButton: Button = view.findViewById(R.id.save_button)

        saveButton.setOnClickListener {
            saveShipment()
        }

        return view
    }




    private fun saveShipment() {
        //val destinoId = (destinoSpinner.selectedItem as Destination).id.toInt()
        val description = descriptionEditText.text.toString().trim()
        val quantity = quantityEditText.text.toString().trim().toInt()

        val newShipment = Shipment(0, description, quantity,1,2,"04/05/2023" , destinoId,consignatarioId,remitenteId,tipoDePaqueteId,documentId)

        shipmentApiService.createShipment(newShipment).enqueue(object : Callback<Shipment> {
            override fun onResponse(call: Call<Shipment>, response: Response<Shipment>) {
                if (response.isSuccessful) {
                    val createdShipment = response.body()
                    Toast.makeText(requireContext(), "Se ha creado el envio : ${createdShipment?.id}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Shipment>, t: Throwable) {
                Toast.makeText(requireContext(), "Error al crear Shipment", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun loadDestinos() {
        destinoApiService.getDestinations().enqueue(object : Callback<List<Destination>> {
            override fun onResponse(
                call: Call<List<Destination>>,
                response: Response<List<Destination>>
            ) {
                if (response.isSuccessful) {
                    val destinos = response.body()
                    destinos?.let { populateDestinoSpinner(it) }
                }
            }

            override fun onFailure(call: Call<List<Destination>>, t: Throwable) {
                Toast.makeText(requireContext(), "Error al obtener los destinos", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    private fun loadConsignatario() {
        consignatarioApiService.getConsignees().enqueue(object : Callback<List<Consignee>> {
            override fun onResponse(
                call: Call<List<Consignee>>,
                response: Response<List<Consignee>>
            ) {
                if (response.isSuccessful) {
                    val datos = response.body()
                    datos?.let { populateConsigneeSpinner(it) }
                }
            }

            override fun onFailure(call: Call<List<Consignee>>, t: Throwable) {
                Toast.makeText(requireContext(), "Error al obtener los datos", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    private fun loadRemitente() {
        remitenteApiService.getRemitentes().enqueue(object : Callback<List<Sender>> {
            override fun onResponse(
                call: Call<List<Sender>>,
                response: Response<List<Sender>>
            ) {
                if (response.isSuccessful) {
                    val datos = response.body()
                    datos?.let { populateSenderSpinner(it) }
                }
            }

            override fun onFailure(call: Call<List<Sender>>, t: Throwable) {
                Toast.makeText(requireContext(), "Error al obtener los datos", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    private fun loadTipoPaquete() {
        tipoDePaqueteApiService.getTipoDePaquetes().enqueue(object : Callback<List<TypeOfPackage>> {
            override fun onResponse(
                call: Call<List<TypeOfPackage>>,
                response: Response<List<TypeOfPackage>>
            ) {
                if (response.isSuccessful) {
                    val datos = response.body()
                    datos?.let { populateTipoDePaqueteSpinner(it) }
                }
            }

            override fun onFailure(call: Call<List<TypeOfPackage>>, t: Throwable) {
                Toast.makeText(requireContext(), "Error al obtener los datos", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    private fun loadDocumento() {
        documentoApiService.getDocumentos().enqueue(object : Callback<List<Document>> {
            override fun onResponse(
                call: Call<List<Document>>,
                response: Response<List<Document>>
            ) {
                if (response.isSuccessful) {
                    val datos = response.body()
                    datos?.let { populateDocumentoSpinner(it) }
                }
            }

            override fun onFailure(call: Call<List<Document>>, t: Throwable) {
                Toast.makeText(requireContext(), "Error al obtener los datos", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    private fun populateDocumentoSpinner(it: List<Document>) {
        val nombres = it.map { it.name }.toTypedArray()
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, nombres)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        documentSpinner.adapter = adapter

        documentSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedData = it[position]
                documentId = selectedData.id
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No se seleccionó ningún elemento
            }
        }
    }

    private fun populateTipoDePaqueteSpinner(it: List<TypeOfPackage>) {
        val nombres = it.map { it.name }.toTypedArray()
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, nombres)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        typeOfPackageSpinner.adapter = adapter

        typeOfPackageSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedData = it[position]
                tipoDePaqueteId = selectedData.id
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No se seleccionó ningún elemento
            }
        }
    }

    private fun populateSenderSpinner(it: List<Sender>) {

        val nombres = it.map { it.name }.toTypedArray()
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, nombres)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        senderSpinner.adapter = adapter

        senderSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedData = it[position]
                remitenteId = selectedData.id
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No se seleccionó ningún elemento
            }
        }

    }

    private fun populateConsigneeSpinner(consignees: List<Consignee>) {

        val consigneeTitles = consignees.map { it.name }.toTypedArray()
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, consigneeTitles)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        consigneesSpinner.adapter = adapter

        consigneesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedData = consignees[position]
                consignatarioId = selectedData.id
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No se seleccionó ningún elemento
            }
        }

    }

    private fun populateDestinoSpinner(destinations: List<Destination>) {
        val destinationTitles = destinations.map { it.name }.toTypedArray()
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, destinationTitles)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        destinoSpinner.adapter = adapter

        destinoSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedAlbum = destinations[position]
                 destinoId = selectedAlbum.id
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No se seleccionó ningún elemento
            }
        }
    }


}