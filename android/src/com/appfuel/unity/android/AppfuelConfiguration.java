package com.appfuel.unity.android;

import com.appfuel.sdk.android.promo.PromoPosition;
import com.appfuel.sdk.android.promo.PromoSize;
import com.unity3d.player.UnityPlayer;

class AppfuelConfiguration
{
	final String appKey;
	final boolean isTesting;
	final PromoSize size;
	final PromoPosition position;
	
	AppfuelConfiguration(String appKey, boolean isTesting, int width, int height, int position)
	{
		this.appKey = appKey;
		this.isTesting = isTesting;
		this.size = new PromoSize(width, height);
		this.position = parsePromoPosition(position);
	}
	
	public static PromoPosition parsePromoPosition(int position)
	{
		switch ( position )
		{
			case 0:
				return PromoPosition.BOTTOM_CENTER;
			case 1:
				return PromoPosition.TOP_CENTER;
			default:
				return PromoPosition.BOTTOM_CENTER;
		}
	}

	public String getAppKey()
	{
		return appKey;
	}

	public boolean isTesting()
	{
		return isTesting;
	}

	public PromoSize getSize()
	{
		return size;
	}

	public PromoPosition getPosition()
	{
		return position;
	}
	
}
