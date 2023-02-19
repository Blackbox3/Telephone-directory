package com.college.campaign.transaction.dto.request;

import com.college.campaign.dto.ModelBase;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MerchantPaymentFieldRequest extends ModelBase {

    private Integer paramOrder;
    private String paramValue;
    private String label;
}
