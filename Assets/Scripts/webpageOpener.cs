using System.Collections;
using System.Collections.Generic;
using UnityEngine;
/// <summary>
/// PORT DU SAGUENAY
///  ____   ______     _____
/// |  o |  | ___ \   /  ___\
/// | ___|  | | | |   | |___
/// | |     | |_| |   \___| \
/// |_|     |____/    \_____/
/// 
/// Script that allows to open a web page containing information about the train.
/// </summary>
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
