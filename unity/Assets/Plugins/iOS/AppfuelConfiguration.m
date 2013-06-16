//
//  AppfuelConfiguration.m
//  appfuel.unity.ios
//
//  Created by Rex Kim on 13-06-06.
//  Copyright (c) 2013 IT Department. All rights reserved.
//

#import "AppfuelConfiguration.h"

@implementation AppfuelConfiguration

@synthesize isTesting, position, appKey, size;

-(void) setSizeWithWidth:(int)aWidth height:(int)aHeight
{
    size = AFPromoSizeFromCGSize(CGSizeMake((float) aWidth, (float) aHeight));
}

-(void) setPositionWithInt:(int)aPosition
{
    switch (aPosition) {
        case 0:
            position = kAFPromoPositionBottomCenter;
            break;
        case 1:
            position = kAFPromoPositionTopCenter;
        default:
            position = kAFPromoPositionBottomCenter;
            break;
    }
}

@end
