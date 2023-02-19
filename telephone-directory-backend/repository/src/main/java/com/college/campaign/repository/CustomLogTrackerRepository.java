package com.college.campaign.repository;

import com.college.campaign.entities.model.CustomLogTracker;
import org.springframework.data.jpa.repository.Query;


public interface CustomLogTrackerRepository extends BaseRepository<CustomLogTracker> {

    @Query("select max(t.trackId) from CustomLogTracker t where t.campaignId =:campaignId")
    Long getTrackerId(Long campaignId);
}
