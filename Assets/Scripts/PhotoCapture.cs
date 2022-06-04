using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

/// <summary>
/// PORT DU SAGUENAY
///  ____   ______     _____
/// |  o |  | ___ \   /  ___\
/// | ___|  | | | |   | |___
/// | |     | |_| |   \___| \
/// |_|     |____/    \_____/
/// 
/// Class that manages the capture of the photo.
/// </summary>
public class PhotoCapture : MonoBehaviour
{
    /// <summary>
    /// Function that start the coroutine to take a screenshot.
    /// </summary>
    public void TakePhoto()
    {
        //start photo coroutine
        StartCoroutine("CaptureIt");
    }

    /// <summary>
    /// IEnumerator linked to the coroutine.
    /// </summary>
    /// <returns></returns>
    IEnumerator CaptureIt()
    {
        //photo capture actions
        string timeStamp = System.DateTime.Now.ToString("dd-MM-yyyy-HH-mm-ss");
        string fileName = "Photo" + timeStamp + ".png";
        string pathToSave = fileName;
        ScreenCapture.CaptureScreenshot(pathToSave);
        yield return new WaitForEndOfFrame();
    }
}
