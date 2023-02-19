package com.college.campaign.repository;

import com.college.campaign.entities.model.CampaignExcelFiles;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CampaignExcelFileRepository extends BaseRepository<CampaignExcelFiles> {

    @Query("select t from CampaignExcelFiles t where t.processStatus=0")
    List<CampaignExcelFiles> findUnprocessedFile();

    @Query("select t from CampaignExcelFiles t where t.campaign.id =:id")
    CampaignExcelFiles getByCampaignId(Long id);
}
