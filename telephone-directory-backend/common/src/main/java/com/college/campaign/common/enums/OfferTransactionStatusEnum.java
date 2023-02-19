package com.college.campaign.common.enums;

import lombok.Getter;


@Getter
public enum OfferTransactionStatusEnum {
    PENDING,
    SUCCESS,
    FAILED,
    TIMEOUT,
    AMBIGUOUS,
    REJECTED
}
