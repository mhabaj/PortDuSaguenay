using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MoveTest : MonoBehaviour
{
    List<GameObject> planets = new List<GameObject>();
    public float amplitude = 1.0f;
    public float speed = 1.0f;
    float y0;
    const float step = Mathf.PI / 10;

    // Start is called before the first frame update
    void Start()
    {
        planets.Add(GameObject.Find("Sphere"));
        planets.Add(GameObject.Find("Sphere1"));
        y0 = planets[0].transform.localPosition.y;
    }

    // Update is called once per frame
    void Update()
    {
        int i = 0;
        foreach (var planet in planets)
        {
            i++;
            Vector3 localPos = planet.transform.localPosition;
            localPos.y = y0 + amplitude * Mathf.Sin(i * step + Time.time * speed);
            planet.transform.localPosition = localPos;
        }
    }
}
