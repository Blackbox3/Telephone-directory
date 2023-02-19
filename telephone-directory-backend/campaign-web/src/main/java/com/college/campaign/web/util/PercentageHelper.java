package com.college.campaign.web.util;


public class PercentageHelper {

    public static double convertToRemainingPercentage(Double spentLimit, Double totalLimit) {
        Double percent = (spentLimit / totalLimit) * 100;
        return Double.parseDouble(String.format("%.2f", percent));
    }


}


