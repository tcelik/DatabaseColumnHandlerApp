package com.hugin.columnhandlerapp.application.controller;

import com.google.protobuf.ServiceException;
import com.hugin.columnhandlerapp.application.service.MyService;
import com.hugin.columnhandlerapp.entity.RowFieldValues;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DatabaseController {
    public Optional<List<RowFieldValues>> fillValues (String sqlCmd) throws ServiceException
    {
        return MyService.INSTANCE.fillValues(sqlCmd);
    }

}
