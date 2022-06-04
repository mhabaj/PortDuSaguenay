package com.uqac.portdusaguenay.activity

import android.content.Context
import android.graphics.Color
import android.os.AsyncTask
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import org.w3c.dom.Element
import org.w3c.dom.Node
import java.lang.Exception
import java.lang.StringBuilder
import java.net.URL
import java.util.ArrayList
import javax.xml.parsers.DocumentBuilderFactory


/**
 * ItineraireTask
 * @author Ludovic
 */
abstract class ItineraryTask(
    /** ATTRIBUTS.
     * / */
    private val context: Context,
    /** */
    private var gMap: GoogleMap, editDepart: String, editArrivee: String
) :
    AsyncTask<Void?, Int?, Boolean>() {
    private val editDepart: String
    private val editArrivee: String
    private val lstLatLng = ArrayList<LatLng>()

    /**
     * {@inheritDoc}
     */
    override fun onPreExecute() {
        Toast.makeText(context, TOAST_MSG, Toast.LENGTH_LONG).show()
    }

    /***
     * {@inheritDoc}
     */
    override fun doInBackground(vararg p0: Void?): Boolean? {
        return try {
            //Construction de l'url à appeler
            val url =
                StringBuilder("http://maps.googleapis.com/maps/api/directions/xml?sensor=false&language=fr")
            url.append("&origin=")
            url.append(editDepart.replace(' ', '+'))
            url.append("&destination=")
            url.append(editArrivee.replace(' ', '+'))

            //Appel du web service
            val stream = URL(url.toString()).openStream()

            //Traitement des données
            val documentBuilderFactory = DocumentBuilderFactory.newInstance()
            documentBuilderFactory.isIgnoringComments = true
            val documentBuilder = documentBuilderFactory.newDocumentBuilder()
            val document = documentBuilder.parse(stream)
            document.documentElement.normalize()

            //On récupère d'abord le status de la requête
            val status = document.getElementsByTagName("status").item(0).textContent
            if ("OK" != status) {
                return false
            }

            //On récupère les steps
            val elementLeg = document.getElementsByTagName("leg").item(0) as Element
            val nodeListStep = elementLeg.getElementsByTagName("step")
            val length = nodeListStep.length
            for (i in 0 until length) {
                val nodeStep = nodeListStep.item(i)
                if (nodeStep.nodeType == Node.ELEMENT_NODE) {
                    val elementStep = nodeStep as Element

                    //On décode les points du XML
                    decodePolylines(elementStep.getElementsByTagName("points").item(0).textContent)
                }
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    /**
     * Méthode qui décode les points en latitudes et longitudes
     * @param points
     */
    private fun decodePolylines(encodedPoints: String) {
        var index = 0
        var lat = 0
        var lng = 0
        while (index < encodedPoints.length) {
            var b: Int
            var shift = 0
            var result = 0
            do {
                b = encodedPoints[index++].toInt() - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlat = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lat += dlat
            shift = 0
            result = 0
            do {
                b = encodedPoints[index++].toInt() - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlng = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lng += dlng
            lstLatLng.add(LatLng(lat.toDouble() / 1E5, lng.toDouble() / 1E5))
        }
    }

    /**
     * {@inheritDoc}
     */
    override fun onPostExecute(result: Boolean) {
        if (!result) {
            Toast.makeText(context, TOAST_ERR_MAJ, Toast.LENGTH_SHORT).show()
        } else {
            //On déclare le polyline, c'est-à-dire le trait (ici bleu) que l'on ajoute sur la carte pour tracer l'itinéraire
            val polylines = PolylineOptions()
            polylines.color(Color.BLUE)

            //On construit le polyline
            for (latLng in lstLatLng) {
                polylines.add(latLng)
            }

            //On déclare un marker vert que l'on placera sur le départ
            val markerA = MarkerOptions()
            markerA.position(lstLatLng[0])
            markerA.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))

            //On déclare un marker rouge que l'on mettra sur l'arrivée
            val markerB = MarkerOptions()
            markerB.position(lstLatLng[lstLatLng.size - 1])
            markerB.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))

            //On met à jour la carte
            gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lstLatLng[0], 10f))
            gMap.addMarker(markerA)
            gMap.addPolyline(polylines)
            gMap.addMarker(markerB)
        }
    }

    companion object {
        /** */
        /** CONSTANTES.
         * / */
        private const val TOAST_MSG = "Calcul de l'itinéraire en cours"
        private const val TOAST_ERR_MAJ = "Impossible de trouver un itinéraire"
    }
    /** */
    /** METHODES / FONCTIONS.
     * / */
    /**
     * Constructeur.
     * @param context
     * @param gMap
     * @param editDepart
     * @param editArrivee
     */
    init {
        gMap = gMap
        this.editDepart = editDepart
        this.editArrivee = editArrivee
    }
}
