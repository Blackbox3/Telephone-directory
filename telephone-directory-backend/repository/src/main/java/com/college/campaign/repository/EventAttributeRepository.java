package com.college.campaign.repository;

import com.college.campaign.entities.model.EventAttribute;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface EventAttributeRepository extends BaseRepository<EventAttribute>{

    @Query("select t from EventAttribute t where t.campaign.id = :id ")
    Optional<EventAttribute> getByCampaignId(Long id);
}
