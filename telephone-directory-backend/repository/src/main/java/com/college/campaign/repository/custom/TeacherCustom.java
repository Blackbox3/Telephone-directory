package com.college.campaign.repository.custom;

import com.college.campaign.entities.model.Teacher;


import java.util.List;


public interface TeacherCustom {

    List<Teacher> searchQuery(String firstName,String mobileNumber);

}
