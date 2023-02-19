package com.college.campaign.web.constant.campaign.dto;

import com.college.campaign.common.dto.ModelBase;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class NtransactionDTO extends ModelBase {
    private Double minimumAmount;
    private Long noOfTransaction;

}
