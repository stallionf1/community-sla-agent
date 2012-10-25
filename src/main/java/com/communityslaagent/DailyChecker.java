package com.communityslaagent;

import com.communityslaagent.services.SlaService;

public class DailyChecker {
    public static void main(String[] args) {
        SlaService ss = new SlaService();
        System.out.println("********* DAILY CHECKER HAS BEEN STARTED ***********");
        ss.getAllUsolvedTopicsWithoutJAnswer();
    }
}
