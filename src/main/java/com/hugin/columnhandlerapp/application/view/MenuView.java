package com.hugin.columnhandlerapp.application.view;

import com.hugin.columnhandlerapp.global.Global;

import java.net.SecureCacheResponse;
import java.util.Scanner;

public class MenuView {
    private Scanner m_kb = new Scanner(System.in);

    private void displayMenu()
    {
        System.out.println("1. select FiscalId, BankMerchant, AppVersion from terminalbanks inner join terminalList on terminalbanks.Terminalid = terminalList.Terminalid");
        System.out.println("2. select BankMerchant, FiscalId, AppVersion from terminalbanks inner join terminalList on terminalbanks.Terminalid = terminalList.Terminalid");
        System.out.println("3. select BankMerchant, FiscalId, AppVersion from terminalbanks inner join terminalList on terminalbanks.Terminalid = terminalList.Terminalid");
        System.out.println("4. select AppVersion, FiscalId, BankMerchant from terminalbanks inner join terminalList on terminalbanks.Terminalid = terminalList.Terminalid");
        System.out.print("Your Option:");
    }

    public String view()
    {
        displayMenu();
        int option = m_kb.nextInt();
        if (option >= 1 && option <= 4)
            return Global.SQLCMD_LIST.get(option);
        else {
            System.out.println("There is no option" + option);
            return null;
        }
    }

}
