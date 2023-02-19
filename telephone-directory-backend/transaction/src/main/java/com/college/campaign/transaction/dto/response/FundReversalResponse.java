package com.college.campaign.transaction.dto.response;

import com.college.campaign.common.dto.ModelBase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FundReversalResponse extends ModelBase {
    private String txnRequestId;
    private boolean reversed;
    private String respCode;
    private String respDesc;
    private String code;
    private String message;
}
