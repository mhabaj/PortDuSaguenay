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
/// Class that hides the button of the screen shoter in order to save a clean photo,
/// and plays the sound of photography.
/// </summary>
public class HidePhotoButton : MonoBehaviour
{
    // button that will be pressed
    [SerializeField] private Button btn = null;

    /// <summary>
    /// audioSource variable to play a sound at capture.
    /// </summary>
    public AudioSource soundPlayer;

    // time until the button is re-enabled after being pressed
    private float timeToWait = 2f;

    private void Start()
    {
        // you can either add the OnClick in the inspector, or you can programmatically add it here
        btn.onClick.AddListener(ClickButton);
    }

    public void ClickButton()
    {
        // do not start the function if we are already in the process
        if (IsInvoking("ReEnableButton"))
            return;

        // disable our button interactability
        //soundplayer actions
        soundPlayer.Play();
        btn.gameObject.SetActive(false);
        btn.interactable = false;

        // call our function ReenableButton in timeToWait seconds
        Invoke("ReEnableButton", timeToWait);
    }

    private void ReEnableButton()
    {
        // re-enable the button
        btn.gameObject.SetActive(true);
        btn.interactable = true;
    }
}
