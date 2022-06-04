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
/// you specify a tmppro text and the ar camera, then you can click on the object to activate or
/// deactivate the text displayed.
/// </summary>
public class InformationDisplayer : MonoBehaviour
{
    [SerializeField]
    private bool IsSelected;

    private Vector2 touchPosition = default;

    [SerializeField]
    private Camera arCamera;

    public bool Selected
    {
        get
        {
            return this.IsSelected;
        }
        set
        {
            IsSelected = value;
        }
    }

    [SerializeField]
    private TMP_Text text;

    // Start is called before the first frame update
    void Start()
    {
    }

    
    /// <summary>
    /// update function used to check if the object is selected or not.
    /// </summary>
    void Update()
    {
        //say if the object is touched
        if(Input.touchCount > 0)
        {
            Touch touch = Input.GetTouch(0);
            touchPosition = touch.position;

            if(touch.phase == TouchPhase.Began)
            {
                Ray ray = arCamera.ScreenPointToRay(touch.position);
                RaycastHit hitObject;

                //if the object is hit by finger
                if (Physics.Raycast(ray, out hitObject))
                {
                    if(Selected == false)
                    {
                        Selected = true;
                    }
                    else
                    {
                        Selected = false;
                    }
                }
            }
        }
        
        //if the object is touched, then the text will activate.
        if(Selected)
        {
            text.gameObject.SetActive(true);
        }
        
        //if the object is touched and the text is activated, then the text will be hidden.
        if(Selected == false)
        {
            text.gameObject.SetActive(false);
        }
    }
}
