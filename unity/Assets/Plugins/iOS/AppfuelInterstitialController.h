//
//  AppfuelInterstitialController.h
//  appfuel.unity.ios
//
//  Created by Rex Kim on 13-06-06.
//  Copyright (c) 2013 IT Department. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <AppfuelSDK/AppfuelSDK.h>
#import "AppfuelTarget.h"
#import "AppfuelConfiguration.h"

@interface AppfuelInterstitialController : UIViewController

@property (strong, nonatomic) AFPromoRequest * request;
@property (strong, nonatomic) AppfuelTarget * target;
@property (strong, nonatomic) AppfuelConfiguration * config;

-(void) load;
-(void) show;
-(BOOL) isReady;

+ (AppfuelInterstitialController *) instance;

@end