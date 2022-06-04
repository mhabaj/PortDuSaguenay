using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

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

    public TMP_Text text;

    // Start is called before the first frame update
    void Start()
    {
    }

    // Update is called once per frame
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

                if (Physics.Raycast(ray, out hitObject))
                {
                    Selected = true;
                }
                
                if(Physics.Raycast(ray, out hitObject) && Selected == true)
                {
                    Selected = false;
                }
            }

        }
        
        //if touched, display text, if not, don't
        if(Selected)
        {
            text.gameObject.SetActive(true);
        }
        
        if(Selected == false)
        {
            text.gameObject.SetActive(false);
        }
    }
}
