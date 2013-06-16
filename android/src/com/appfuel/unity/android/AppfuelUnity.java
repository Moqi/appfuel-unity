package com.appfuel.unity.android;

import android.app.Activity;
import android.widget.LinearLayout;

import com.appfuel.sdk.android.promo.Promo;
import com.appfuel.sdk.android.promo.PromoError;
import com.appfuel.sdk.android.promo.PromoListener;
import com.appfuel.sdk.android.promo.PromoView;
import com.unity3d.player.UnityPlayer;

public class AppfuelUnity
{
	final static String LOGTAG = "AppfuelUnity";
	
	private boolean isInitialized;
	private Activity activity;
	private PromoView promoView;
	private LinearLayout layout;
	private AppfuelTarget target;
	private AppfuelConfiguration config;
	private final PromoListener promoListener = new PromoListener() {
		
		@Override
		public void onPromoShown(Promo promo)
		{
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onPromoClosed(Promo promo)
		{
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onLoadPromo(Promo promo)
		{
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onFailedToLoadPromo(Promo promo, PromoError error)
		{
			// TODO Auto-generated method stub
			
		}
	};
	
	private static AppfuelUnity _instance = null;
	
	AppfuelUnity()
	{
		isInitialized = false;
	}
	
	public static AppfuelUnity getInstance(String appKey, int width, int height, int position, int year, int month, int day)
	{	
		if ( _instance == null )
		{
			_instance = new AppfuelUnity();
		}
		_instance.init(appKey, width, height, position, year, month, day);
		return _instance;
	}
	
	public void init(String appKey, int width, int height, int position, int year, int month, int day)
	{
		if ( !isInitialized )
		{
			return;
		}
		
		this.activity = UnityPlayer.currentActivity;
		this.layout = new LinearLayout(this.activity);
	}
}
