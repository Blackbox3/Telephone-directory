package com.college.campaign.dto;

import lombok.Data;

import java.util.List;


@Data
public class RegistrationReportResponse extends ModelBase {

    private List<RegistrationReportDetail> registrationReports;
}
