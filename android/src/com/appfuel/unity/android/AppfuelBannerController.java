package com.appfuel.unity.android;

import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import com.appfuel.sdk.android.promo.Promo;
import com.appfuel.sdk.android.promo.PromoError;
import com.appfuel.sdk.android.promo.PromoListener;
import com.appfuel.sdk.android.promo.PromoPosition;
import com.appfuel.sdk.android.promo.PromoRequest;
import com.appfuel.sdk.android.promo.PromoView;

public class AppfuelBannerController implements PromoListener
{
	static final String LOG_TAG = "BannerController";
	private Activity activity;
	private PromoView view;
	private PromoRequest request;
	private AppfuelConfiguration config;
	private String boundedGameObject;
	private AppfuelTarget target;
	
	private static AppfuelBannerController _instance;
	
	private AppfuelBannerController(String appKey, boolean isTesting, int width, int height, int position)
	{
		config = new AppfuelConfiguration(appKey, isTesting, width, height, position);
		
	}
	
	public static AppfuelBannerController getInstance(String appKey, boolean isTesting, int width, int height, int position)
	{
		if ( _instance == null )
		{
			AppfuelBannerController._instance = new AppfuelBannerController(appKey, isTesting, width, height, position);
		}
		
		return AppfuelBannerController._instance;
	}
	
	public void setTarget(int gender, String[] keywords, int year, int month, int day)
	{
		target = new AppfuelTarget(gender, keywords, year, month, day);
	}
	
	private void load()
	{
		this.view.request(this.request);
	}
	
	private void hide()
	{
		this.view.stopLoading();
		this.view.setVisibility(View.GONE);
	}
	
	private void addAdView()
	{
		LinearLayout layout = new LinearLayout(activity);
		PromoPosition position = this.config.getPosition();
		if (PromoPosition.TOP_CENTER.equals(position))
		{
			layout.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
		} 
		else if (PromoPosition.BOTTOM_CENTER.equals(position))
		{
			layout.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
		}
		
		activity.addContentView(layout, new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		this.view = new PromoView(this.activity, this.config.getSize(), this.config.getAppKey());
		this.view.setListener(this);
		layout.addView(view);
	}

	@Override
	public void onLoadPromo(Promo promo)
	{
		Log.d(LOG_TAG, "Received");
	}

	@Override
	public void onFailedToLoadPromo(Promo promo, PromoError error)
	{
		// TODO Auto-generated method stub
		Log.d(LOG_TAG, "Failed with Error : " + error);
	}

	@Override
	public void onPromoShown(Promo promo)
	{
		// TODO Auto-generated method stub
		Log.d(LOG_TAG, "onPromoShown");
	}

	@Override
	public void onPromoClosed(Promo promo)
	{
		Log.d(LOG_TAG, "onPromoClosed");
	}
	
}
