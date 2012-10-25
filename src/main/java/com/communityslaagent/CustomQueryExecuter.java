package com.communityslaagent;

import com.communityslaagent.services.UsersService;

public class CustomQueryExecuter {

    public static void main(String[] args) {
       new UsersService().executeCustomQuery(); //accroding to property community.sql.custom-query
    }
}
