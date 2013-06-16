//
//  AFPromoDelegate.h
//  AppfuelSDK
//
//  Created by Myung Sun Kim on 13-03-23.
//  Copyright (c) 2013 Myung Sun Kim. All rights reserved.
//

#import <Foundation/Foundation.h>

@class AFPromoError;
@protocol Promo;

@protocol AFPromoDelegate <NSObject>

@required
@optional
-(void) promoDidFinishLoading:(id<Promo>) aPromo;
-(void) promo:(id<Promo>)aPromo failedToLoadWithError:(AFPromoError *) error;
@end
