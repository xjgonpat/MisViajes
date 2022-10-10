package com.example.misviajes

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.misviajes.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        //Escribimos lo referente al binding dentro del bloque with.
        with(binding)
        {
            setContentView(root)
            //llamamos al adapter.
             recycler.adapter= LugaresAdapter(
                 listaLugares,
             ){
                 //Usamos URI para realizar el intent.
                 // Le mandamos la latitud y longitud del lugar queremos que abra.
                 val intentUri: Uri =
                     Uri.parse("google.streetview:cbll=${it.lat},${it.lon}")
                 val intent = Intent(Intent.ACTION_VIEW, intentUri)
                 startActivity(intent)
             }

        }
    }
    //Definimos una lista de lugares.
    val listaLugares = listOf(
        Lugar("Barcelona",
            "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/15/4d/45/49/province-of-barcelona.jpg?w=1600&h=1100&s=1",
            "41.395227", "2.175336"),
        Lugar("Sevilla",
            "https://images.squarespace-cdn.com/content/v1/5a86b05bcf81e0af04936cc7/1657901179340-KUOF0AHLFCZYB9TCMXZL/setas-sevilla.jpg?format=1500w",
            "37.375632", "-5.991228"),
        Lugar("Cádiz",
            "https://wordpress-network.prod.aws.skyscnr.com/wp-content/uploads/2018/05/spain-andalucia-cadiz-cathedral-quay-night-511388970.jpg",
            "36.518164", "-6.279087"),
        Lugar ("Berlín",
            "https://content.r9cdn.net/rimg/dimg/66/73/57707be7-city-9109-162d3eba142.jpg?width=1200&height=630&crop=true",
            "52.490477", "13.389795")
    )

}