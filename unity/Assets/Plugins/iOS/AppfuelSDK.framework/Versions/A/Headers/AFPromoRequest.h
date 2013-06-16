//
//  AFPromoRequest.h
//  AppfuelSDK
//
//  Created by Myung Sun Kim on 13-03-20.
//  Copyright (c) 2013 Myung Sun Kim. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "AFGender.h"

@interface AFPromoRequest : NSObject

// MARK: properties
@property (nonatomic) AFGender gender;
@property (strong, nonatomic) NSDate * birthDate;
@property (strong, nonatomic) NSMutableArray * keywords;
@property (nonatomic) BOOL testMode;

// MARK: Easy init method
// Default Promorequest Constructor
// This method creates AFPromoRequest with empty keywords, empty birthDate, and non testMode request
-(id) init;

// Default auto releasable Promorequest
// This method creates AFPromoRequest with empty keywords, empty birthDate, and non testMode request
+ (AFPromoRequest *) request;

// MARK: Public methods

// This constructors allows users to initialize AFPromoRequest with given testmode flag
-(id) initWith: (BOOL) testMode;

-(void) addKeyword: (NSString * ) aKeyword;
-(void) removeKeyword: (NSString * ) aKeyword;

@end
