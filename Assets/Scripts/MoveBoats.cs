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
/// script that make the boats move up and down like it's on water.
/// </summary>
public class MoveBoats : MonoBehaviour
{
    List<GameObject> boats = new List<GameObject>();
    public float amplitude = 1.0f;
    public float speed = 1.0f;
    float y0;
    const float step = Mathf.PI / 10;

    // Start is called before the first frame update
    void Start()
    {
        boats.Add(GameObject.Find("staticBoat_2"));
        boats.Add(GameObject.Find("staticBoat_3"));

        y0 = boats[0].transform.localPosition.y;
    }

    // Update is called once per frame
    void Update()
    {
        int i = 0;
        foreach(var boat in boats)
        {
            i++;
            Vector3 localPos = boat.transform.localPosition;
            localPos.y = y0 + amplitude + Mathf.Sin(i * step * Time.time * speed);
            boat.transform.localPosition = localPos;
        }
    }
}
