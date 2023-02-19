package com.college.campaign.transaction.dto;

import com.college.campaign.common.dto.ModelBase;
import com.college.campaign.entities.model.RequestInfo;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Getter
@Setter
public class TxnParameter extends ModelBase {

    @NotNull(message = "Request could not be stored")
    private RequestInfo requestInfo;
    private Long customerId;
    private String initiator;
    private String customerName;
    //    private CommissionInfo commissionInfo;
    private String fromAccount;
    private String toAccount;
    private Double amount;
    private Map<String, String> isoMap;
    private String extraCharge;
    private Double extraChargeAmount;
    private String remarks;
//    private ChargeRequest chargeRequest;
    /*
    For fonepay transaction extra charge commission,
    True only for Fonepay transaction
     */
    private boolean hasExtraCommission;

    private BranchDetail branchInfoDTO;
    private String serviceCode;
}
