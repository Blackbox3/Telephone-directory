package com.college.campaign.repository.Util;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class FieldQueryParameter {

    //column name
    private String key;
    //column value
    private Object value;


    public FieldQueryParameter() {
        this.key = null;
        this.value = null;
    }

}
