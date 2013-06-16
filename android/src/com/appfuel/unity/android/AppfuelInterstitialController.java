package com.appfuel.unity.android;

import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import com.appfuel.sdk.android.promo.InterstitialPromo;
import com.appfuel.sdk.android.promo.Promo;
import com.appfuel.sdk.android.promo.PromoError;
import com.appfuel.sdk.android.promo.PromoListener;
import com.appfuel.sdk.android.promo.PromoPosition;
import com.appfuel.sdk.android.promo.PromoRequest;
import com.unity3d.player.UnityPlayer;

public class AppfuelInterstitialController implements PromoListener
{
	static final String LOG_TAG = "InterstitialController";
	private Activity activity;
	private AppfuelConfiguration config;
	private InterstitialPromo view;
	private AppfuelTarget target;
	private PromoRequest request;
	
	private static AppfuelInterstitialController _instance;
	
	AppfuelInterstitialController(String appKey, boolean isTesting)
	{
		config = new AppfuelConfiguration(appKey, isTesting, 0, 0, 0);
	}
	
	
	public static AppfuelInterstitialController getInstance(String appKey, boolean isTesting)
	{
		if ( AppfuelInterstitialController._instance == null )
		{
			AppfuelInterstitialController._instance = new AppfuelInterstitialController(appKey, isTesting);
		}
		
		return AppfuelInterstitialController._instance;
	}
	
	public void setTarget(int gender, String[] keywords, int year, int month, int day)
	{
		target = new AppfuelTarget(gender, keywords, year, month, day);
	}
	
	public void load()
	{
		this.activity = UnityPlayer.currentActivity;
		activity.runOnUiThread(new Runnable(){

			@Override
			public void run()
			{
				AppfuelInterstitialController.this.addAdView();
				AppfuelInterstitialController.this.request = target == null ? new PromoRequest() : AppfuelInterstitialController.this.target.getPromoRequest();
				AppfuelInterstitialController.this.request.setTestMode(AppfuelInterstitialController.this.config.isTesting());
				AppfuelInterstitialController.this.view.request(AppfuelInterstitialController.this.request);
			}
			
		});
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
		
		this.view = new InterstitialPromo(this.activity, this.config.getAppKey());
		this.view.setListener(this);
	}

	@Override
	public void onLoadPromo(Promo promo)
	{
		Log.d(LOG_TAG, "Received");
		this.activity.runOnUiThread(new Runnable() {
			
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				AppfuelInterstitialController.this.view.show();
			}
		});
		
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
