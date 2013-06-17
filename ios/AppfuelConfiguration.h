//
//  AppfuelConfiguration.h
//  appfuel.unity.ios
//
//  Created by Rex Kim on 13-06-06.
//  Copyright (c) 2013 IT Department. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <AppfuelSDK/AppfuelSDK.h>

@interface AppfuelConfiguration : NSObject

@property (strong, nonatomic) NSString * appKey;
@property BOOL isTesting;
@property AFPromoSize size;
@property AFPromoPosition position;

-(void) setSizeWithWidth:(int)aWidth height:(int)aHeight;
-(void) setPositionWithInt:(int)aPosition;
@end
