package com.college.campaign.common.util;

import lombok.extern.slf4j.Slf4j;



@Slf4j
public class StringUtil {

    public static boolean validateNullOrEmpty(String text) {

        return text == null || text.trim().length() == 0;
    }
}
