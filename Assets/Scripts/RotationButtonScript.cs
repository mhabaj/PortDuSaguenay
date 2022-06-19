using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;
using UnityEngine.UI;

/// <summary>
/// 
/// PORT DU SAGUENAY
///  ____   ______     _____
/// |  o |  | ___ \   /  ___\
/// | ___|  | | | |   | |___
/// | |     | |_| |   \___| \
/// |_|     |____/    \_____/
/// 
/// 
/// Script of the button that allows to rotate the text if the train.
/// </summary>
public class RotationButtonScript : MonoBehaviour
{
    public TMP_Text text;
    public Button button;
    public Button button2;

    public void rotateCanvas()
    {
        text.transform.Rotate(0,180,0);
        button.transform.Rotate(0,180,0);
        button2.transform.Rotate(0, 180, 0);
    }
}
