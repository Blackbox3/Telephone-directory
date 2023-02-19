package com.college.campaign.repository;

import com.college.campaign.entities.model.DefaultIsoParam;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DefaultIsoParamRepository extends BaseRepository<DefaultIsoParam> {

    @Query("select t from DefaultIsoParam t WHERE t.active = 'Y' and t.type = :type")
    List<DefaultIsoParam> getDefaultIsoParamByType(String type);
}
