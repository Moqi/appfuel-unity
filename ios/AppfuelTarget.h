//
//  AppfuelTarget.h
//  appfuel.unity.ios
//
//  Created by Rex Kim on 13-06-06.
//  Copyright (c) 2013 IT Department. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <AppfuelSDK/AppfuelSDK.h>

@interface AppfuelTarget : NSObject

@property AFGender gender;
@property NSMutableArray * keywords;
@property NSDate * birthDate;
@property BOOL isTesting;

-(void) setGenderWithInt:(int) gender;
-(void) setBirthDateWithYear:(int)aYear month:(int)aMonth day:(int)aDay;
-(void) setKeywordsWithChar: (char **) aKeywords;

-(AFPromoRequest *) toRequest;
@end
