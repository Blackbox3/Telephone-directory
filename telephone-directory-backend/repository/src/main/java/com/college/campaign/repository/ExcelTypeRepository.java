package com.college.campaign.repository;

import com.college.campaign.entities.model.ExcelType;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ExcelTypeRepository extends BaseRepository<ExcelType> {

    @Query("select t from ExcelType t where t.type =:type and t.active='Y'")
    Optional<ExcelType> findByType(String type);
}
