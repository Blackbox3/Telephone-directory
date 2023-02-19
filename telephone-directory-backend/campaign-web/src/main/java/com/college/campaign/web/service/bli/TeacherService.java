package com.college.campaign.web.service.bli;

import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import com.college.campaign.web.bli.dto.TeacherCreateRequest;
import com.college.campaign.web.bli.dto.TeacherSearchRequest;

public interface TeacherService {

    TelephoneDirectoryResponses createTeacher(TeacherCreateRequest teacherCreateRequest);

    TelephoneDirectoryResponses searchCampaign(TeacherSearchRequest teacherSearchRequest);
}
