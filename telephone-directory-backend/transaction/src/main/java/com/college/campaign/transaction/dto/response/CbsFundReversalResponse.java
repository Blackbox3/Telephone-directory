package com.college.campaign.transaction.dto.response;

import com.college.campaign.common.dto.ModelBase;
import lombok.Getter;
import lombok.Setter;

/*
 * @Author Rashim Dhaubanjar
 */

@Getter
@Setter
public class CbsFundReversalResponse extends ModelBase {

    private String requestId;
    private String respCode;
    private String respDesc;
}
