//
//  AppfuelBannerController.m
//  appfuel.unity.ios
//
//  Created by Rex Kim on 13-06-06.
//  Copyright (c) 2013 IT Department. All rights reserved.
//

#import "AppfuelBannerController.h"

@interface AppfuelBannerController() <AFPromoDelegate>
{
    BOOL isReady;
    AFPromoView * promoView;
}
@end

@implementation AppfuelBannerController

@synthesize request, target, config;

static AppfuelBannerController * instance;

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

// MARK: AFPromoDelegate Method
-(void) promoDidFinishLoading:(id<Promo>) aPromo
{
    // INSERT YOUR CODE FOR YOUR OWN DELEGATE BEHAVIOR
    isReady = YES;
    [self show];
}

-(void) promo:(id<Promo>)aPromo failedToLoadWithError:(AFPromoError *) error
{
    // INSERT YOUR CODE FOR YOUR OWN DELEGATE BEHAVIOR
     NSLog(@"Error :%@", error);
    [self stop];
}

// MARK: Public methods
-(void) load
{
    if ( target )
    {
        request = [target toRequest];
    }
    
    if ( !request )
    {
        request = [AFPromoRequest request];
    }
    
    [request setTestMode:config.isTesting];
    promoView = [[AFPromoView alloc] initWithSize:config.size];
    promoView.appKey = config.appKey;
    promoView.delegate = self;
    [promoView request:request];
}

-(void) show
{
    if ( !promoView )
    {
        return;
    }
    
    // Add promoView to self.view if and only if promoView is not added yet
    if ( ![promoView isDescendantOfView: self.view] )
    {
        [self.view addSubview:promoView];
        
        // Setting up promo position
        if ( config.hasPosition )
        {
            [promoView setPosition:config.position];
        }
    }

}

-(void) stop
{
    if ( promoView )
    {
        // Releasing promoView
        promoView = nil;
    }
}

-(BOOL) isReady
{
    return isReady;
}

-(void) dealloc
{
    [super dealloc];
    instance = nil;
    promoView = nil;
}

+ (AppfuelBannerController *) instance
{
    if ( !instance )
    {
        instance = [[AppfuelBannerController alloc] init];
    }
    
    return instance;
}

@end

// MARK: Plug-in Methods
void initBanner_(char * appKey, bool isTesting, int width, int height)
{
    AppfuelBannerController * controller = [AppfuelBannerController instance];
    AppfuelConfiguration * aConfig = [[AppfuelConfiguration alloc] init];
    [aConfig setSizeWithWidth:width height:height];
    [aConfig setAppKey:[NSString stringWithUTF8String:appKey]];
    [controller setConfig:aConfig];
}

void setBannerTarget_(int gender, char ** keywords, int year, int month, int day)
{
    AppfuelTarget * target = [[AppfuelTarget alloc] init];
    [target setGenderWithInt:gender];
    [target setKeywordsWithChar:keywords];
    [target setBirthDateWithYear:year month:month day:day];
    
    AppfuelBannerController * controller = [AppfuelBannerController instance];
    [controller setTarget:target];
}

void loadBanner_()
{
    AppfuelBannerController * controller = [AppfuelBannerController instance];
    [controller load];
}

void stopBanner_()
{
    AppfuelBannerController * controller = [AppfuelBannerController instance];
    [controller stop];
}

