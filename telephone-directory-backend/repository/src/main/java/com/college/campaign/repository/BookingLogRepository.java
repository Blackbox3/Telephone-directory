package com.college.campaign.repository;

import com.college.campaign.entities.model.BookingLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface BookingLogRepository extends BaseRepository<BookingLog> {

    @Query("select t from BookingLog t where t.campaign.id = :campaignId")
    Optional<BookingLog> findByCampaign(@Param("campaignId") Long campaignId);
}
