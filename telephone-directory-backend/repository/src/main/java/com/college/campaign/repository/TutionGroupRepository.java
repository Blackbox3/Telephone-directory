package com.college.campaign.repository;

import com.college.campaign.entities.model.TutionGroup;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TutionGroupRepository extends BaseRepository<TutionGroup>{

    @Query("select t from TutionGroup t where t.id =:id and t.active = 'Y'")
    Optional<TutionGroup> findTutionGroupById(Long id);
}
