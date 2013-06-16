package com.appfuel.unity.android;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import android.util.Log;

import com.appfuel.sdk.android.promo.PromoRequest;
import com.appfuel.sdk.android.promo.PromoRequest.Gender;

class AppfuelTarget
{
	public final Gender gender;
	public final Set<String> keywords;
	public final Date birthday;
	public final boolean isTesting;
	
	AppfuelTarget(int gender, String[] keywords, int birthYear, int birthMonth,
			int birthDay)
	{
		this(gender, keywords, birthYear, birthMonth, birthDay, false);
	}
	
	AppfuelTarget(int gender, String[] keywords, int birthYear, int birthMonth,
			int birthDay, boolean isTesting)
	{
		this.gender = AppfuelTarget.parseGender(gender);
		this.birthday = AppfuelTarget.parseBirthday(birthYear, birthMonth,
				birthDay);
		this.keywords = AppfuelTarget.parseKeywords(keywords);
		this.isTesting = isTesting;
	}

	private static Gender parseGender(int gender)
	{

		switch (gender)
		{
			case 1:
				return Gender.MALE;
	
			case 2:
				return Gender.FEMALE;
		}

		return Gender.ALL;
	}

	private static Date parseBirthday(int year, int month, int day)
	{

		Date birthday = null;

		try
		{
			if ( year == 0 && month == 0 && day == 0 )
			{
				return null;
			}
			
			birthday = new GregorianCalendar(year, month, day).getTime();

		} 
		catch (Exception error)
		{
			Log.e("Error", "error", error);
		}

		return birthday;
	}

	private static Set<String> parseKeywords(String[] keywords)
	{

		Set<String> set = new HashSet<String>();

		for (String keyword : keywords)
		{

			if (keyword != null && !set.contains(keyword))
			{

				set.add(keyword);
			}
		}

		return (set);
	}
	
	public PromoRequest getPromoRequest()
	{
		PromoRequest req = new PromoRequest();
		if ( this.birthday != null )
		{
			req.setBirthDate(this.birthday);
		}
		
		
		for ( String keyword : this.keywords )
		{
			req.addKeyword(keyword);
		}
		req.setGender(this.gender);
		req.setTestMode(isTesting);
		return req;
	}	
}
