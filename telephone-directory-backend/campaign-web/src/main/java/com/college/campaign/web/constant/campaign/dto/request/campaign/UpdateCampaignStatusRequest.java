package com.college.campaign.web.constant.campaign.dto.request.campaign;

import com.college.campaign.common.dto.ModelBase;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
public class UpdateCampaignStatusRequest extends ModelBase {

    @NotNull
    private Long id;
    @NotNull
    private String status;
    private String remarks;
}
