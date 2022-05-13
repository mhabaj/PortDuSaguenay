using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;
using UnityEngine.UI;

public class GPSCore : MonoBehaviour
{
    public float Lat;
    public float Lon;
    private double distance;
    private Vector3 targetPosition;
    private Vector3 originalPosition;
    public float radius = 5f; //range of target function start
    public float timeUpdate = 3f; //time of comparison of the current coordinate with target per seconds
    private string newLat;
    private string newLon;
    float lat;
    float lon;
    public GameObject targetPopup; //the popup UI page when the user will reach the target position
    public bool targetPopupOneTime; //check when the popup appears, so the gameobject appears once

    public TextMeshProUGUI t; // debug 

    private void Start()
    {
        if (!UnityEngine.Android.Permission.HasUserAuthorizedPermission(UnityEngine.Android.Permission.CoarseLocation))
        {
            UnityEngine.Android.Permission.RequestUserPermission(UnityEngine.Android.Permission.CoarseLocation);
        }
        Input.location.Start(); //calls the gps of the device an tries to connect it to satellite
        StartCoroutine("GPSProcess");//compare the current location with the lat and lon of the target
    }

    public IEnumerator GPSProcess()
    {
        while (true)
        {
            if (!UnityEngine.Android.Permission.HasUserAuthorizedPermission(UnityEngine.Android.Permission.CoarseLocation))
            {
                UnityEngine.Android.Permission.RequestUserPermission(UnityEngine.Android.Permission.CoarseLocation);
            }
            yield return new WaitForSeconds(timeUpdate); //every 3 s
            if (Input.location.isEnabledByUser == true) //check if the gps is enabled by the user
            {
                Input.location.Start();

                lat = Input.location.lastData.latitude;
                newLat = lat.ToString();//easier to compare strings than numbers
                lon = Input.location.lastData.longitude;
                newLon = lon.ToString();//easier to compare strings than numbers


                t.text = "lat : " + newLat + " lon : " + lon + " Lat : " + Lat + " Lon : " + Lon;

                Calc(Lat, Lon, lat, lon);

            }
            else
            {
                t.text = "le gps n'est pas détecté";
            }
        }
    }

    /// <summary>
    /// compare system of our current position and that position.
    /// </summary>
    public void Calc(float lat1, float lon1, float lat2, float lon2)
    {
        var R = 6378.137; //radius of earth in km.
        var dLat = lat2 * Mathf.PI / 180 - lat1 * Mathf.PI / 180;
        var dLon = lon2 * Mathf.PI / 180 - lon1 * Mathf.PI / 180;
        float a = Mathf.Sin(dLat / 2) * Mathf.Sin(dLat / 2) + 
            Mathf.Cos(lat1 * Mathf.PI / 180) * Mathf.Cos(lat2 * Mathf.PI / 180) *
            Mathf.Sin(dLon / 2) * Mathf.Sin(dLon / 2);
        var c = 2 * Mathf.Atan2(Mathf.Sqrt(a), Mathf.Sqrt(1 - a));
        distance = R * c;
        distance = distance * 1000f;
        float distanceFloat = (float)distance;
        targetPosition = originalPosition - new Vector3(0, 0, distanceFloat * 12);

        if(distance < radius) //when we are inside of the radius
        {
            if(targetPopupOneTime == false)
            {
                targetPopup.SetActive(true);
            }
        }

        if(distance > radius) // out of the radius
        {
            targetPopup.SetActive(false);
        }
    }

    public void HideTargetPopup()
    {
        targetPopup.SetActive(false);
        targetPopupOneTime = true;
    }
}
