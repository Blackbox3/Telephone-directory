package com.college.campaign.repository;

import com.college.campaign.entities.model.RegistrationLogTracker;
import org.springframework.data.jpa.repository.Query;


public interface RegistrationLogTrackerRepository extends BaseRepository<RegistrationLogTracker> {

    @Query("select max(r.trackId) from RegistrationLogTracker r")
    Long getTrackerId();
}
