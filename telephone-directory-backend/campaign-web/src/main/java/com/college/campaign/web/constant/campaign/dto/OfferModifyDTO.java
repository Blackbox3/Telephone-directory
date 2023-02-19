package com.college.campaign.web.constant.campaign.dto;

import com.college.campaign.common.dto.ModelBase;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OfferModifyDTO extends ModelBase {

    private Long id;
    private Double minAmount;
    private Double maxAmount;
    private String value;
    private String commissionType;
    private String mode;
}
