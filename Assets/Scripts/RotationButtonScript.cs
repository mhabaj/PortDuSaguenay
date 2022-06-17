using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;
using UnityEngine.UI;

public class RotationButtonScript : MonoBehaviour
{
    public TMP_Text text;
    public Button button;


    public void rotateCanvas()
    {
        text.transform.Rotate(0,180,0);
        button.transform.Rotate(0,180,0);
    }
}
