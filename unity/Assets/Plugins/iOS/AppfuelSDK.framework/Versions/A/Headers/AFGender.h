//
//  AFGender.h
//  AppfuelSDK
//
//  Created by Myung Sun Kim on 13-03-23.
//  Copyright (c) 2013 Myung Sun Kim. All rights reserved.
//

#import <Foundation/Foundation.h>

typedef enum {
    ALL,
    MALE,
    FEMALE
} AFGender;

// MARK: Enumeration HELPER Method

// Converts the given setring to AFGender enum value
AFGender AFGenderFromNSString( NSString * gender );

// Converts the given gender to NSString
NSString * NSStringFromAFGender(AFGender gender);



