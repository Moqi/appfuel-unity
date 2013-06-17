//
//  AFPromoSize.h
//  AppfuelSDK
//
//  Created by Myung Sun Kim on 13-03-20.
//  Copyright (c) 2013 Myung Sun Kim. All rights reserved.
//

#import <UIKit/UIKit.h>

typedef struct AFPromoSize
{
    float width;
    float height;
} AFPromoSize;

// MARK: PreSet Sizes

// Typicall banner size for smart phones. (320 x 50)
extern AFPromoSize const kAFPromoSizeBANNER;

// Typical big banner size for tablets ( 720 x 80 )
extern AFPromoSize const kAFPromoSizeLEADERBOARD;

// MARK: Enumeration HELPER Functions for AFPromoSize
AFPromoSize AFPromoSizeFromCGSize(CGSize size);

// With Given AFPromoSize returns the proper GCSize
// If AFPromoSize is not valid size, it will return CGSizeZro
CGSize CGSizeFromAFPromoSize(AFPromoSize size);

// MARK: Convinience Functions
BOOL IsAFPromoSizeValid(AFPromoSize size);

// Compares to given AFPromoSize and determines whether they are equal
// This function is equivalent to Java equals(Object other) method
BOOL IsAFPromoSizeEqualToSize(AFPromoSize size1, AFPromoSize size2);

// Returns String equivalent of the given AFPromoSize.
// This function is equivalent to Java Enum name() method
NSString * NSStringFromAFPromoSize(AFPromoSize size);
