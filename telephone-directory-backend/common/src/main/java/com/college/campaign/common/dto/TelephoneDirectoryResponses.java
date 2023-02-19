package com.college.campaign.common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TelephoneDirectoryResponses extends ModelBase {

    private boolean success;
    private String message;
    private String code;
    private Object obj;
    public String unicodeMessage;

    public TelephoneDirectoryResponses(boolean success) {
        this.success = success;
    }
}
