//
//  Promo.h
//  AppfuelSDK
//
//  Created by Myung Sun Kim on 13-03-20.
//  Copyright (c) 2013 Myung Sun Kim. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "AFPromoDelegate.h"
@class AFPromoRequest;

@protocol Promo<NSObject>

-(void) request: (AFPromoRequest *) aRequest;
-(void) requestWithFlag: (BOOL) testMode;
-(void) setDelegate: (id<AFPromoDelegate>) delegate;

@end
