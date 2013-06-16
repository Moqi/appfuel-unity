using UnityEngine;
using System.Collections;

namespace Appfuel
{
	[System.Serializable]
	public enum Gender { ALL, MALE, FEMALE }
	
	[System.Serializable]
	public enum PromoPosition { BOTTOM_CENTER, TOP_CENTER }
	
	/// <summary>
	/// Promo size.
	/// </summary>
	[System.Serializable]
	public class PromoSize
	{
		public static readonly PromoSize BANNER = new PromoSize(320, 50);
		public static readonly PromoSize LEADER_BOARD = new PromoSize(720, 80);
		
		public int width;
		public int height;
		
		public PromoSize(int width, int height)
		{
			this.width = width;
			this.height = height;
		}
	}
	
}
