package com.hugin.columnhandlerapp.application.controller;

import com.hugin.columnhandlerapp.application.service.MyService;
import com.hugin.columnhandlerapp.entity.RowFieldValues;

import java.sql.SQLException;
import java.util.List;

public class DatabaseController {
    public MyService service = MyService.INSTANCE;
    public List<RowFieldValues> fillValues (String strSelect) throws SQLException
    {
        return service.fillValues(strSelect);
    }

}
