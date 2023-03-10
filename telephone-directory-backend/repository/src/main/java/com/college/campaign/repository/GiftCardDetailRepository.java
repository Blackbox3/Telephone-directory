package com.college.campaign.repository;

import com.college.campaign.entities.model.GiftCard;
import com.college.campaign.repository.custom.GiftCardDetailCustom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface GiftCardDetailRepository extends BaseRepository<GiftCard>, GiftCardDetailCustom {

    @Query("select t from GiftCard t order by t.id desc")
    List<GiftCard> getAllGiftCardDetailList();

    @Query("select t from GiftCard t where t.active = 'Y' ")
    List<GiftCard> findAllActive();

    @Query("select t from GiftCard t where t.active = 'Y' AND t.code=:code")
    Optional<GiftCard> getGiftCardDetailByCode(@Param("code") String code);
}
