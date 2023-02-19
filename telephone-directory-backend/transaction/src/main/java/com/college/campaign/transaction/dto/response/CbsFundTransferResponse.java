package com.college.campaign.transaction.dto.response;

import com.college.campaign.common.dto.ModelBase;
import lombok.Getter;
import lombok.Setter;

/*
 * @Author Rashim Dhaubanjar
 */

@Getter
@Setter
public class CbsFundTransferResponse extends ModelBase {

    private String requestId;
    private String stanId;
    private String respCode;
    private String respDesc;
    private String benificiaryName;
}
