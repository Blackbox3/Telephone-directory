package com.college.campaign.repository.Util;


import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SearchQueryParameter {

    private List<FieldQueryParameter> search;

    private String fromDate;
    private String toDate;

    @NotNull
    private Integer page;
    @NotNull
    private Integer size;


}
