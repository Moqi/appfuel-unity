//
//  AppfuelTarget.m
//  appfuel.unity.ios
//
//  Created by Rex Kim on 13-06-06.
//  Copyright (c) 2013 IT Department. All rights reserved.
//

#import "AppfuelTarget.h"

@implementation AppfuelTarget

@synthesize isTesting, birthDate, gender, keywords;

-(void) setBirthDateWithYear:(int)aYear month:(int)aMonth day:(int)aDay
{
    if ( aYear == 0 && aMonth == 0 && aDay == 0 )
    {
        birthDate = nil;
        return;
    }
    
    NSDateComponents * comp = [[NSDateComponents alloc] init];
    [comp setYear:aYear];
    [comp setMonth: aMonth];
    [comp setDay:aDay];
    
    birthDate = [[NSCalendar currentCalendar] dateFromComponents:comp];
}

-(void) setGenderWithInt:(int) aGender
{
    switch (aGender) {
        case 0:
            gender = ALL;
            break;
        case 1:
            gender = MALE;
            break;
        case 2:
            gender = FEMALE;
            break;
        default:
            gender = ALL;
            break;
    }
}

-(void) setKeywordsWithChar: (char **) aKeywords
{
    int i = 0;
    if ( !keywords )
    {
        keywords = [NSMutableArray array];
    }
    
    for ( i = 0; aKeywords[i] != NULL; i++ )
    {
        [keywords addObject:[NSString stringWithUTF8String:aKeywords[i]]];
    }
}

-(AFPromoRequest *) toRequest
{
    AFPromoRequest * request = [AFPromoRequest request];
    if ( birthDate )
    {
        [request setBirthDate:birthDate];
    }
    
    if ( keywords )
    {
        [request setKeywords:keywords];
    }
    
    if ( gender )
    {
        [request setGender:gender];
    }
    
    return request;
}

@end
