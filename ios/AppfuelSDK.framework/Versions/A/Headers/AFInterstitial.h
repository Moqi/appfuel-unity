//
//  AFInterstitial.h
//  AppfuelSDK
//
//  Created by Myung Sun Kim on 13-04-17.
//  Copyright (c) 2013 Myung Sun Kim. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "AFInterstitialDelegate.h"
#import "AFPromoRequest.h"

@interface AFInterstitial : NSObject

-(id) initWithAppKey:(NSString *) appKey;

// MARK:: Pre-Request Configs
// Application Key that is given from the Appfuel Dashboard
@property (strong, nonatomic, setter = setAppKey:) NSString * appKey;
@property (strong, nonatomic) AFPromoRequest * promoRequest;
@property (weak, nonatomic) id <AFInterstitialDelegate> delegate;

// MARK: Promo Request
- (void) requestWithFlag:(BOOL) isTest;
- (void) request:(AFPromoRequest *) request;

// MARK: Post-Request Status

// Return YES if the interstitial is ready to be presented.
// When this flag turns from NO to YES, AFInterstitialDelegate will fire
// interstitialDidFinishLoading:(AFInterstitial *) AFInterstitial
@property (nonatomic, readonly) BOOL isReady;

// Returns YES if the interstitial's content is consumed / showed to users
// Not that an interstitial object can be only consumed once.
// Once interstitial is consumed (void) request: method will be obsolete
@property (nonatomic, readonly) BOOL isConsumed;

- (void) showFrom:(UIViewController *) rootViewController;


@end
