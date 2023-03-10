package com.college.campaign.transaction.dto;

import com.college.campaign.common.dto.ModelBase;
import lombok.Getter;
import lombok.Setter;

/*
 * @Author Rashim Dhaubanjar
 */

@Getter
@Setter
public class Partner extends ModelBase {

    private String accountNo;
    private String commissionCode;
    private Double amount;
}
