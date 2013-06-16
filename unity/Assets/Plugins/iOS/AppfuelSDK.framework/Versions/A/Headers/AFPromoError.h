//
//  AFPromoError.h
//  AppfuelSDK
//
//  Created by Myung Sun Kim on 13-03-27.
//  Copyright (c) 2013 Myung Sun Kim. All rights reserved.
//

#import <Foundation/Foundation.h>

extern NSString * const kAFPromoErrorDomain;

typedef enum {
    // The Promo Request was not made due to Network problem
    kNetworkError,
    
    // The Promo Request was made, but Appfuel's Server is down
    kServerError,
    
    // The Promo Request is made with invalid application keys
    kInvalidAppKey,
    
    // The Promo Request is madd too frequently
    kFrequentRequest,
    
} AFPromoErrorCode;

@interface AFPromoError : NSError

@end
