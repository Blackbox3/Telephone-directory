package com.college.campaign.repository;

import com.college.campaign.entities.model.Teacher;
import com.college.campaign.repository.custom.TeacherCustom;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends BaseRepository<Teacher> , TeacherCustom {

    @Query("select t from Teacher t where t.firstName =:firstName and t.mobileNumber1=:mobileNumber and t.mobileNumber2=:mobileNumber")
    List<Teacher> findTeacherByFirstNameAndMobileNumber1(String firstName,String mobileNumber);
}
