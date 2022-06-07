using System;
using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;
using UnityEngine.Networking;
using UnityEngine.UI;

/// <summary>
/// PORT DU SAGUENAY
///  ____   ______     _____
/// |  o |  | ___ \   /  ___\
/// | ___|  | | | |   | |___
/// | |     | |_| |   \___| \
/// |_|     |____/    \_____/
/// 
///Class that changes the weather in accordance with the date of the system.
/// </summary>
public class WeatherData : MonoBehaviour
{
	public ParticleSystem effect;
	public GameObject weather;

	public void Start()
	{
		//obtain the date of the system
		DateTime todayDate = DateTime.Now;

		//fetch the particle system
		effect = GetComponent<ParticleSystem>();

		//date of beginning and end of seasons
		DateTime springDebut = new DateTime(todayDate.Year, 03, 22);
		DateTime springEnd = new DateTime(todayDate.Year, 06, 21);

		DateTime summerDebut = new DateTime(todayDate.Year, 06, 22);
		DateTime summerEnd = new DateTime(todayDate.Year, 09, 21);

		DateTime fallDebut = new DateTime(todayDate.Year, 09, 22);
		DateTime fallEnd = new DateTime(todayDate.Year, 12, 21);

		DateTime winterDebut = new DateTime(todayDate.Year, 12, 22);
		DateTime winterEnd = new DateTime(todayDate.Year, 03, 21);

		//check which season corresponds to the date
		if(IsBetweenTwoDates(todayDate, springDebut, springEnd) && weather.CompareTag("spring"))
        {
			effect.Play();
        }else if(IsBetweenTwoDates(todayDate, summerDebut, summerEnd) && weather.CompareTag("summer"))
        {
			effect.Play();
        }else if(IsBetweenTwoDates(todayDate, fallDebut, fallEnd) && weather.CompareTag("fall"))
        {
			effect.Play();
        }else if(IsBetweenTwoDates(todayDate, winterDebut, winterEnd) && weather.CompareTag("winter"))
        {
			effect.Play();
        }
        else
        {
        }
	}

	/// <summary>
	/// checks if the date is between start and end.
	/// </summary>
	/// <param name="dt"></param>
	/// <param name="start"></param>
	/// <param name="end"></param>
	/// <returns></returns>
	public bool IsBetweenTwoDates(DateTime dt, DateTime start, DateTime end)
	{
		return dt > start && dt < end;
	}
}