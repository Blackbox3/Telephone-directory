package com.college.campaign.repository.Util;


public class QueryFormatter {

    public static String escapeString(String str) {
        if (str != null && str.length() > 0) {
            str = str.replace("\\", "")
                    .replace("'", "")
                    .replace("\n", "")
                    .replace("\r", "")
                    .replace("\"", "");
        }
        return str;
    }
}
