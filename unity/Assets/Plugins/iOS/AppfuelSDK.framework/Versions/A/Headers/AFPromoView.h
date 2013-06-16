//
//  AFPromoView.h
//  AppfuelSDK
//
//  Created by Myung Sun Kim on 13-03-20.
//  Copyright (c) 2013 Myung Sun Kim. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Promo.h"
#import "AFPromoSize.h"
#import "AFPromoRequest.h"
#import "AFPromoDelegate.h"

typedef enum
{
    kAFPromoPositionBottomCenter,
    kAFPromoPositionTopCenter,
} AFPromoPosition;

@interface AFPromoView : UIView<Promo>

// Application Key that is given from the Appfuel Dashboard
@property (strong, nonatomic, setter = setAppKey:) NSString * appKey;
@property (strong, nonatomic) AFPromoRequest * promoRequest;
@property (nonatomic) AFPromoSize size;
@property (weak, nonatomic) id <AFPromoDelegate> delegate;

// MARK: Init and Cacao stuffs
-(id) initWithSize: (AFPromoSize) aSize;
-(id) initWithSize: (AFPromoSize) aSize origin: (CGPoint) aOrigin;

// MARK:: Request methods
-(void) requestWithFlag: (BOOL) testMode;
-(void) request: (AFPromoRequest *) aRequest;
-(void) setDelegate:(id<AFPromoDelegate>) delegate;

// MARK:: Positioning
-(void) setPosition: (AFPromoPosition) aPosition;

@end
