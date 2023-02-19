package com.college.campaign.web.constant.campaign.dto;

import com.college.campaign.common.dto.ModelBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfferCreateDTO extends ModelBase {

    private Double minAmount;
    private Double maxAmount;
    private String value;
    private String commissionType;
    private String mode;
}
