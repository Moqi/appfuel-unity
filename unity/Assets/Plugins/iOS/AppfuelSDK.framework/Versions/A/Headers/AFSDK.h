//
//  AppfuelSDK.h
//  AppfuelSDK
//
//  Created by Myung Sun Kim on 13-03-20.
//  Copyright (c) 2013 Myung Sun Kim. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface AppfuelSDK : NSObject

@property (strong, nonatomic) NSString * appKey;

-(void) initWith:(NSString *) appKey;

+ (AppfuelSDK *) instance;

@end
