using UnityEngine;
using System.Collections;
using System.Runtime.InteropServices;
using Appfuel;

/// <summary>
/// Appfuel banner controller.
/// </summary>
public class AppfuelBannerController : MonoBehaviour 
{
	private bool isInitialized = false;
	public string iosAppKey;
	public string androidAppKey;
	public bool isTesting;
	
	public PromoSize size;
	public Gender gender;
	public PromoPosition position;
	public string[] keywords;	
	private static AppfuelBannerController _instance;

#if UNITY_ANDROID && !UNITY_EDITOR	
	private AndroidJavaObject androidController;
	private AndroidJavaObject activity;
#endif
#if UNITY_IPHONE && !UNITY_EDITOR
	[DllImport("__Internal")]
	private static extern void initBanner_(string appKey, bool isTesting, int width, int height);
	
	// Use This function to set Targeted request
	[DllImport("__Internal")]
	private static extern void setBannerTarget_(Gender gender, string[] keywords, int year, int month, int day);
	
	[DllImport("__Internal")]
	private static extern void loadBanner_();
	
	[DllImport("__Internal")]
	private static extern void stopBanner_();
#endif
	
	private void Init()
	{
		if ( this.isInitialized == true )
		{
			return;
		}
#if UNITY_ANDROID && !UNITY_EDITOR
		// TODO:: do something for Android
		if ( this.androidAppKey == null )
		{
			Debug.Log("Need appKey");
		}
		
		AndroidJavaClass controllerClass = new AndroidJavaClass("com.appfuel.unity.android.AppfuelBannerController");
		androidController = controllerClass.CallStatic<AndroidJavaObject>(
				"getInstance",
				this.androidAppKey,
				this.isTesting,
				this.size.width,
				this.size.height,
				this.position
			);
		
#endif
		
#if UNITY_IPHONE && !UNITY_EDITOR
		// TODO:: do something for iPhone
		if( this.iosAppKey == null )
		{
			Debug.Log("Need android AppKey");
		}
		initBanner_(this.iosAppKey, this.isTesting, this.size.width, this.size.height);
#endif
		this.isInitialized = true;
	}
	
	public void setBirthDay(int year, int month, int day)
	{
#if UNITY_ANDROID && !UNITY_EDITOR
		androidController.Call(
				"setBirthDay",
				year,
				month,
				day
			);
#endif
#if UNITY_IPHONE && !UNITY_EDITOR
		
#endif
	}
	
	void Load()
	{
#if UNITY_ANDROID && !UNITY_EDITOR
		this.androidController.Call("load");
#endif

#if UNITY_IPHONE && !UNITY_EDITOR
		loadBanner_();
#endif
	}
	
	void Awake()
	{
		if ( _instance == null )
		{
			_instance = this;
			DontDestroyOnLoad(gameObject);
		}
		else
		{
			Destroy(gameObject);
		}
	}
	
	// Use this for initialization
	void Start () 
	{
		Debug.Log("Starting");
#if UNITY_ANDROID && !UNITY_EDITOR
		if ( !this.isInitialized )
		{
			this.Init();
		}
		this.Load();
#endif
#if UNITY_IPHONE && !UNITY_EDITOR
		Debug.Log ("IPhone Init");
		if ( !this.isInitialized )
		{
			this.Init();
		}
		this.Load();
#endif
	}
	
	// Update is called once per frame
	void Update () {
	
	}
}
