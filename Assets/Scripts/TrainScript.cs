using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TrainScript : MonoBehaviour
{
    public Animator anim;
    public float animSpeed = 0.001f;
    // Start is called before the first frame update
    void Start()
    {
        anim = GetComponent<Animator>();
        anim.speed = animSpeed;
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
