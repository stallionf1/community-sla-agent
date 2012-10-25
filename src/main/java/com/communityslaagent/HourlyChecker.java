package com.communityslaagent;

import com.communityslaagent.services.SlaService;

public class HourlyChecker {
    public static void main(String[] args) {
        SlaService ss = new SlaService();
        System.out.println("********* HOURLY CHECKER HAS BEEN STARTED ***********");
        ss.getAllOpenedTopicsCurrentSlaStatus();
    }
 
            
}
