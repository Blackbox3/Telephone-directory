package com.college.campaign.transaction.dto.request;

import com.college.campaign.common.dto.ModelBase;
import lombok.Getter;
import lombok.Setter;

/*
 * @Author Rashim Dhaubanjar
 */

@Getter
@Setter
public class FundReversalRequest extends ModelBase {

    private String requestId;
    private String remarks;

}
