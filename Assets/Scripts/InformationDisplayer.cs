using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

/// <summary>
/// PORT DU SAGUENAY
///  ____   ______     _____
/// |  o |  | ___ \   /  ___\
/// | ___|  | | | |   | |___
/// | |     | |_| |   \___| \
/// |_|     |____/    \_____/
/// 
/// Information displayer class that allows us to display an information on top of an object.
/// you specify a TMP_Text text and the ar camera, then you can click on the object to activate or
/// deactivate the text displayed.
/// </summary>
public class InformationDisplayer : MonoBehaviour
{
    public string idText;

    private bool Selected;

    public TMP_Text text;

    public string textToDisplay;

    public Canvas canvas;

    /// <summary>
    /// Function that make the text appear or disappear when an object is touched.
    /// </summary>
    void OnMouseDown()
    {
        if (text.name.Equals(idText))
        {
            if (Selected == false)
            {
                Selected = true;
                text.text = textToDisplay;
                text.gameObject.SetActive(true);
                canvas.gameObject.SetActive(true);
            }
            else
            {
                Selected = false;
                text.gameObject.SetActive(false);
                canvas.gameObject.SetActive(false);
            }
        }
    }
}