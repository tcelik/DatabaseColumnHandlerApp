package com.hugin.columnhandlerapp.application;

import com.hugin.columnhandlerapp.application.controller.DatabaseController;
import com.hugin.columnhandlerapp.dao.DBClientDao;
import com.hugin.columnhandlerapp.entity.FieldValue;
import com.hugin.columnhandlerapp.entity.RowFieldValues;

import java.util.List;

public class App {
    public static void main(String[] args)
    {
        try {
            DBClientDao.INSTANCE.testDriver();
            System.out.println("Driver testi geçti");

            String dynamicTable = "terminalbanks";
            String strSelectFmt = "select AppVersion, terminalList.TerminalId, DefaultBank from %s" + " " +
                    "inner join terminalList on terminalbanks.Terminalid = terminalList.Terminalid";
            String strSelect = String.format(strSelectFmt, dynamicTable);

            //Get the result and for each
            DatabaseController controller = new DatabaseController();
            List<RowFieldValues> rowFieldValuesList = controller.fillValues(strSelect);

            //show the result if you want.
            int index = 0;
            for (RowFieldValues rfvl : rowFieldValuesList) {
                System.out.println(index++ + "-satır");
                for (FieldValue fv : rfvl.getFieldValues()) {
                    System.out.println(fv.toString());
                }
            }
         }
        catch (ClassNotFoundException e) {
            System.out.println("Driver düzgün yüklenemedi...");
            System.exit(1);
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
