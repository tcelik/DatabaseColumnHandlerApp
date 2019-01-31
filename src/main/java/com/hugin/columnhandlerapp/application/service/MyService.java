package com.hugin.columnhandlerapp.application.service;

import com.hugin.columnhandlerapp.dao.DBClientDao;
import com.hugin.columnhandlerapp.entity.RowFieldValues;

import java.sql.SQLException;
import java.util.List;


public enum  MyService {
    INSTANCE;
    public List<RowFieldValues> fillValues (String strSelect) throws SQLException
    {
        return DBClientDao.INSTANCE.fillValues(strSelect);
    }
}
