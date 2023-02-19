package com.college.campaign.repository;

import com.college.campaign.entities.model.OfferMode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface OfferModeRepository extends BaseRepository<OfferMode> {

    @Query("select t from OfferMode t where t.code = :code ")
    Optional<OfferMode> getByCode(@Param("code") String code);

}
