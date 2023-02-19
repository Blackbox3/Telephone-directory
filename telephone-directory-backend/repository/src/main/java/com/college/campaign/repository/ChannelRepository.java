package com.college.campaign.repository;

import com.college.campaign.entities.model.Channel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface ChannelRepository extends BaseRepository<Channel> {

    @Query("select t from Channel t where t.code = :code")
    Optional<Channel> getChannelByCode(@Param("code") String code);
}
