using UnityEngine;
using System.Collections;
using System.Runtime.InteropServices;
using Appfuel;

public class AppfuelInterstitialController : MonoBehaviour 
{
	private bool isInitialized = false;
	
	public string iosAppKey;
	public string androidAppKey;
	public bool isTesting;
	
	public Gender gender;
	public string[] keywords;	
	private static AppfuelInterstitialController _instance;

#if UNITY_ANDROID && !UNITY_EDITOR	
	private AndroidJavaObject androidController;
	private AndroidJavaObject activity;
#endif
#if UNITY_IPHONE && !UNITY_EDITOR
	[DllImport("__Internal")]
	private static extern void initInterstitial_(string appKey, bool isTesting);
	
	[DllImport("__Internal")]
	private static extern void setInterstitialTarget_(Gender gender, string[] keywords, int year, int month, int day);
	
	[DllImport("__Internal")]
	private static extern void loadInterstitial_();
#endif
	
	private void Init()
	{
		Debug.Log("Loading");
#if UNITY_ANDROID && !UNITY_EDITOR
		if ( this.androidAppKey == null )
		{
			Debug.Log("Need appKey");
			this.androidAppKey = "51a4965fe4b03cc1cdcee2dc";
			this.isTesting = true;
		}
		AndroidJavaClass jc = new AndroidJavaClass("com.appfuel.unity.android.AppfuelInterstitialController");
		Debug.Log ("Retrieved Class");
		this.androidController = jc.CallStatic<AndroidJavaObject>(
				"getInstance",
				this.androidAppKey,
				this.isTesting
			);
		
#endif
		
#if UNITY_IPHONE && !UNITY_EDITOR
		//TODO:: do something for iPhone
		if( this.iosAppKey == null )
		{
			Debug.Log("Need android AppKey");
		}
		
		initInterstitial_(this.iosAppKey, this.isTesting);
		
#endif
		this.isInitialized = true;
	}
	
	/// <summary>
	/// Gets the Singleton instance.
	/// </summary>
	/// <returns>
	/// The instance.
	/// </returns>
	
	void Load()
	{
#if UNITY_ANDROID && !UNITY_EDITOR
		this.androidController.Call("load");
#endif

#if UNITY_IPHONE && !UNITY_EDITOR
		loadInterstitial_();
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
	void Update () 
	{
		
	}
}
