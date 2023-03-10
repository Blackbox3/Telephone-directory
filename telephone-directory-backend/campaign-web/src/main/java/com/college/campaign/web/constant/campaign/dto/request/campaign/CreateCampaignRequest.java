package com.college.campaign.web.constant.campaign.dto.request.campaign;

import com.college.campaign.web.constant.campaign.dto.CampaignServiceDTO;
import com.college.campaign.web.constant.campaign.dto.NtransactionDTO;
import com.college.campaign.web.constant.campaign.dto.OfferCreateDTO;
import com.college.campaign.web.constant.campaign.dto.UserDTO;
import com.college.campaign.web.dto.ProfileDTO;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class CreateCampaignRequest{

    @NotEmpty
    private String title;
    @NotEmpty
    private String shortDescription;
    @NotEmpty
    private String description;
    private String promoCode;
    @NotEmpty
    private String startDate;
    @NotEmpty
    private String endDate;
    @NotEmpty
    private String policy;
    @NotNull
    private int totalIssued;
    @NotNull
    private int usagePerCustomer;
    @NotNull
    private int expiryTime;
    private String eventType;
    @NotNull
    private char isWeb;
    @NotNull
    private char isMobile;
    private List<OfferCreateDTO> offers;
    private List<CampaignServiceDTO> services;
    private List<ProfileDTO> profiles;
    private String image;
    private String link;
    @NotEmpty
    private String allowedUsers;
    @NotEmpty
    private String offerAccount;
    private List<UserDTO> userList;
    private String excelFileName;
    private Long eventTypeId;
    private NtransactionDTO ntransaction;
    private String campaignMode;
    private Long customCbsQueryId;
    @NotNull
    private Double totalOfferAmount;

}
