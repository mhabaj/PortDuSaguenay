using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;
using UnityEngine.Android;

/// <summary>
/// PORT DU SAGUENAY
///  ____   ______     _____
/// |  o |  | ___ \   /  ___\
/// | ___|  | | | |   | |___
/// | |     | |_| |   \___| \
/// |_|     |____/    \_____/
/// 
///Class allows us to display the current location of the user
/// </summary>
public class UserLocation : MonoBehaviour
{
    public TMP_Text debug; // debug 

    private void Start()
    {
#if UNITY_ANDROID
        if (!Permission.HasUserAuthorizedPermission(Permission.FineLocation))
        {
            Permission.RequestUserPermission(Permission.FineLocation);
        }
#elif UNITY_IOS
                  PlayerSettings.iOS.locationUsageDescription = "Details to use location";
#endif
        StartCoroutine(StartLocationService());
    }

    private IEnumerator StartLocationService()
    {
        if (!Input.location.isEnabledByUser)
        {
            debug.text = "User has not enabled location";
            yield break;
        }
        Input.location.Start();
        while (Input.location.status == LocationServiceStatus.Initializing)
        {
            yield return new WaitForSeconds(1);
        }
        if (Input.location.status == LocationServiceStatus.Failed)
        {
            debug.text = "Unable to determine device location";
            yield break;
        }
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.location.status == LocationServiceStatus.Running)
        {
            //Access granted to GPS values and it has been init
            debug.text = "(updated) Latitude : " + Input.location.lastData.latitude + "; Longitude : " + Input.location.lastData.longitude + "; Altitude : " + Input.location.lastData.altitude;
        }
        else
        {
            //there is a problem within the function
            debug.text = "unable to start coroutine";

        }
    }

}
