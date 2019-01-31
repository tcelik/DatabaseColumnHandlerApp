package com.hugin.columnhandlerapp.global;

import java.util.ArrayList;

public class Global {
    //Properties config.
    public static final String URL = "jdbc:mysql://localhost:3306/testdb";
    public static final String USER = "root";
    public static final String PASSWORD = "csd19933";


    //GLOBAL SQLCMD LİST
    public static ArrayList<String> SQLCMD_LIST = new ArrayList<>();
    public static final String SQLCMD1 = "select FiscalId, BankMerchant, AppVersion from terminalbanks inner join terminalList on terminalbanks.Terminalid = terminalList.Terminalid";
    public static final String SQLCMD2 = "select BankMerchant, FiscalId, AppVersion from terminalbanks inner join terminalList on terminalbanks.Terminalid = terminalList.Terminalid";
    public static final String SQLCMD3 = "select BankMerchant, FiscalId, AppVersion from terminalbanks inner join terminalList on terminalbanks.Terminalid = terminalList.Terminalid";
    public static final String SQLCMD4 = "select AppVersion, FiscalId, BankMerchant from terminalbanks inner join terminalList on terminalbanks.Terminalid = terminalList.Terminalid";

    static {
        SQLCMD_LIST.add(SQLCMD1);
        SQLCMD_LIST.add(SQLCMD2);
        SQLCMD_LIST.add(SQLCMD3);
        SQLCMD_LIST.add(SQLCMD4);
    }
}
