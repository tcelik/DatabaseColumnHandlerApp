package com.hugin.columnhandlerapp.application.service;

import com.hugin.columnhandlerapp.dao.DBClientDao;
import com.hugin.columnhandlerapp.entity.RowFieldValues;
import com.hugin.columnhandlerapp.exception.DaoException;
import com.hugin.columnhandlerapp.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public enum  MyService {
    INSTANCE;

    public Optional<List<RowFieldValues>> fillValues(String sqlCmd) throws ServiceException
    {
        try {
            return DBClientDao.INSTANCE.fillValues(sqlCmd);
        } catch (Throwable e) {
            throw new ServiceException("fillValues", e);
        }
    }
}
