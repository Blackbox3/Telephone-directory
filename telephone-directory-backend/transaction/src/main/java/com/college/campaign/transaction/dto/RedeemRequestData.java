package com.college.campaign.transaction.dto;

import com.college.campaign.entities.model.ApplicationUser;
import com.college.campaign.entities.model.Campaign;
import com.college.campaign.entities.model.OfferTransaction;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RedeemRequestData {

    private OfferTransaction offerTransaction;
    private Campaign campaign;
    private String accountNumber;
    private String toAccount;
    private Double amount;
    private String remarks;
    private ApplicationUser applicationUser;
}
