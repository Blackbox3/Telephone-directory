package com.college.campaign.repository;

import com.college.campaign.entities.model.CustomCBSQuery;
import com.college.campaign.repository.custom.CBSQueryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;


public interface CustomCbsQueryRepository extends QuerydslPredicateExecutor<CustomCBSQuery>, JpaRepository<CustomCBSQuery,Long>, CBSQueryCustom {

    @Query("select t from CustomCBSQuery t where t.id =:customCbsQueryId")
    Optional<CustomCBSQuery> findCbsQueryById(Long customCbsQueryId);

    @Query("select c from CustomCBSQuery c where c.queryCode =:queryCode")
    Optional<CustomCBSQuery> findByQueryCode(String queryCode);
}
