//
//  AFInterstitialDelegate.h
//  AppfuelSDK
//
//  Created by Myung Sun Kim on 13-04-17.
//  Copyright (c) 2013 Myung Sun Kim. All rights reserved.
//

#import <Foundation/Foundation.h>

@class AFInterstitial;
@class AFPromoError;

@protocol AFInterstitialDelegate <NSObject>

@optional

// MARK: Interstitial Life Cycle Notification
-(void) interstitialDidFinishLoading:(AFInterstitial *) AFInterstitial;
-(void) interstitial:(AFInterstitial *)aPromo failedToLoadWithError:(AFPromoError *) error;
-(void) interstitialWillPresnetScreen:(AFInterstitial *) interstitial;
-(void) interstitialWillDismissScreen:(AFInterstitial *) interstitial;

@end
