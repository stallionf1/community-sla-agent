/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.communityslaagent;

import com.communityslaagent.services.SlaService;

public class DailyChecker {
    public static void main(String[] args) {
        SlaService ss = new SlaService();
        System.out.println("********* DAILY CHECKER HAS BEEN STARTED ***********");
        ss.getAllUsolvedTopicsWithoutJAnswer();
    }
}
