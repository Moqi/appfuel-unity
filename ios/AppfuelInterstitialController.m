//
//  AppfuelInterstitialController.m
//  appfuel.unity.ios
//
//  Created by Rex Kim on 13-06-06.
//  Copyright (c) 2013 IT Department. All rights reserved.
//

#import "AppfuelInterstitialController.h"

@interface AppfuelInterstitialController() <AFInterstitialDelegate>
{
    AFInterstitial * interstitial;
    BOOL isReady;
}

@end

// MARK: Implementation
@implementation AppfuelInterstitialController

@synthesize target, config, request;

static AppfuelInterstitialController * instance = nil;

-(id) init
{
    self = [super init];
    if ( self )
    {
        isReady = NO;
        UIWindow *window = [[UIApplication sharedApplication] keyWindow];
        self.view = [[UIView alloc] initWithFrame:window.bounds];
        [window addSubview:self.view];
    }
    return self;
}

// MARK : Delegate methods
-(void) interstitialDidFinishLoading:(AFInterstitial *) AFInterstitial
{
    isReady = YES;
    [interstitial showFrom:self];
}
-(void) interstitial:(AFInterstitial *)aPromo failedToLoadWithError:(AFPromoError *) error
{
    NSLog(@"Error :%@", error);
}

-(void) interstitialWillPresnetScreen:(AFInterstitial *) interstitial
{
    NSLog(@"Presenting on Screen");
}

-(void) interstitialWillDismissScreen:(AFInterstitial *) interstitial
{
    NSLog(@"Dissmissing on Screen");
}

// MARK : public methods
-(void) load
{
    request = [target toRequest];
    [request setTestMode:config.isTesting];
    [interstitial request:request];
}


-(void) show
{
    if ( interstitial && isReady )
    {
        [interstitial showFrom:self];
    }
}

-(BOOL) isReady
{
    return isReady;
}

-(void) setConfig:(AppfuelConfiguration *)aConfig
{
    config = aConfig;
    if ( !interstitial )
    {
        interstitial = [[AFInterstitial alloc] initWithAppKey:config.appKey];
        interstitial.delegate = self;
        
    }
    else
    {
        interstitial.appKey = config.appKey;
    }
}

-(void) dealloc
{
    instance = nil;
    interstitial = nil;
}

// MARK: Static Instance Method
+ (AppfuelInterstitialController *) instance
{
    if ( !instance )
    {
        instance = [[AppfuelInterstitialController alloc] init];
    }
    
    return instance;
}
@end

void initInterstitial_(char * appKey, bool isTesting)
{
    AppfuelInterstitialController * controller = [AppfuelInterstitialController instance];
    AppfuelConfiguration * aConfig = [[AppfuelConfiguration alloc] init];
    [aConfig setAppKey:[NSString stringWithUTF8String:appKey]];
    [controller setConfig:aConfig];
}

void setInterstitialTarget_(int gender, char ** keywords, int year, int month, int day)
{
    AppfuelTarget * target = [[AppfuelTarget alloc] init];
    [target setGenderWithInt:gender];
    [target setKeywordsWithChar:keywords];
    [target setBirthDateWithYear:year month:month day:day];
    
    AppfuelInterstitialController * controller = [AppfuelInterstitialController instance];
    [controller setTarget:target];
}

void loadInterstitial_()
{
    AppfuelInterstitialController * controller = [AppfuelInterstitialController instance];
    [controller load];
}

