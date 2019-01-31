package com.hugin.columnhandlerapp.application;

import com.google.protobuf.ServiceException;
import com.hugin.columnhandlerapp.application.controller.DatabaseController;
import com.hugin.columnhandlerapp.application.view.MenuView;
import com.hugin.columnhandlerapp.application.view.ShowResultView;
import com.hugin.columnhandlerapp.dao.DBClientDao;
import com.hugin.columnhandlerapp.entity.FieldValue;
import com.hugin.columnhandlerapp.entity.RowFieldValues;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args)
    {
        //User defined sql cmd menu.
        MenuView menuView = new MenuView();
        String sqlCmd = menuView.view();

        //Operation
        try {
            DatabaseController controller = new DatabaseController();
            Optional<List<RowFieldValues>> rowFieldValuesListOpt = controller.fillValues(sqlCmd);

            if(!rowFieldValuesListOpt.get().isEmpty()) {
                ShowResultView resultview = new ShowResultView(rowFieldValuesListOpt.get());
                resultview.view();
            }
            else {
                System.out.println("Optional.empty");
            }
        }
        catch (ServiceException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

}
