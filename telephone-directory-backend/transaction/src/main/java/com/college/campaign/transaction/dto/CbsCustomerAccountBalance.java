package com.college.campaign.transaction.dto;

import com.college.campaign.common.dto.ModelBase;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CbsCustomerAccountBalance extends ModelBase {

    private String accountNumber;

    private Double ledgerBalance;
    private String ledgerBalanceType;

    private Double availableBalance;
    private String availableBalanceType;

    private Double accruedInterest;
    private Double interestRate;
    private String accountStatus;
    private String currencyCode;

    public String getInterestRate() {
        if (interestRate != null) {
            return String.valueOf(interestRate);
        } else {
            return "N/A";
        }
    }
}
