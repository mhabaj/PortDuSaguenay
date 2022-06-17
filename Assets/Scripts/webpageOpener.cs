using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class webpageOpener : MonoBehaviour
{

    /// <summary>
    /// when text is clicked, page opens.
    /// </summary>
    public void OpenPage()
    {
        //open web page
        Application.OpenURL("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fsaguenaytrain%2Fposts%2F3835241579918792");
    }
}
