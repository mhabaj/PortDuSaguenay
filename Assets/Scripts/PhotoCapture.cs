using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class PhotoCapture : MonoBehaviour
{
    public void TakePhoto()
    {
        StartCoroutine("CaptureIt");
    }

    IEnumerator CaptureIt()
    {
        string timeStamp = System.DateTime.Now.ToString("dd-MM-yyyy-HH-mm-ss");
        string fileName = "Photo" + timeStamp + ".png";
        string pathToSave = fileName;
        ScreenCapture.CaptureScreenshot(pathToSave);
        yield return new WaitForEndOfFrame();
    }
}
