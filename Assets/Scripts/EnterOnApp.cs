using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

public class EnterOnApp : MonoBehaviour
{
    public TMP_Text openingMessage;//opening message of the application

    // Start is called before the first frame update
    void Start()
    {
        openingMessage.text = "Bienvenu dans le mode réalité augmentée !";
        StartCoroutine(onCoroutine());
    }

    /// <summary>
    /// coroutine that allows to display the message for a few seconds and then it disappears.
    /// </summary>
    /// <returns></returns>
    IEnumerator onCoroutine()
    {
        while (true)
        {
            yield return new WaitForSeconds(5f);
            openingMessage.gameObject.SetActive(false);
        }
    }
}
