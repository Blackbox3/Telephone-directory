package com.college.campaign.transaction.dto;

import com.college.campaign.common.dto.ModelBase;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class FundTransferInfo extends ModelBase {
    private String initiator;
    private String fromAccount;
    private String toAccount;
    private Double amount;
    private Long requestId;
    private String currencyCode;
    private Map<String, String> isoParam;
    private HashMap<String, Double> partnersAmount;
    private double extraChargeAmount;
    private String extraChargeType;
    private BranchDetail branch;
    private String serviceCode;
    private Long txnRequestId;
    private boolean doReversal;
}
