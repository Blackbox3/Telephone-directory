package com.college.campaign.repository;

import com.college.campaign.entities.model.Service;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface ServiceRepository extends BaseRepository<Service> {

    @Query("select t from Service t where t.code = :code")
    Optional<Service> getServiceByCode(@Param("code") String code);
}
