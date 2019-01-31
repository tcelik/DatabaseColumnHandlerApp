package com.hugin.columnhandlerapp.dao;

import com.hugin.columnhandlerapp.entity.FieldValue;
import com.hugin.columnhandlerapp.entity.RowFieldValues;
import com.hugin.columnhandlerapp.exception.DaoException;
import com.hugin.columnhandlerapp.global.Global;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;
import java.util.logging.Logger;

public enum DBClientDao {
    INSTANCE;

    private final static Logger log = Logger.getLogger(DBClientDao.class.getName());


    private void testDriver() throws DaoException
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Throwable ex) {
            log.info("Driver-not-suitable");
            throw new DaoException("testDriver", ex);
        }
    }

    private Optional<List<RowFieldValues>> getRowFieldValueListFromResultSet(ResultSet rs) throws DaoException
    {

        List<RowFieldValues> rowFieldValuesResultList = new ArrayList<>();

        try {
            ResultSetMetaData rsmd = rs.getMetaData();

            if (!rs.next()) {
                log.info("there is no row");
            }
            else {
                log.info("Operation is starting...");
                RowFieldValues rfvlist; // FieldValue wrapper

                do {
                    rfvlist = new RowFieldValues(); //clear

                    //column-base iteration for each rs
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        String colName = rsmd.getColumnName(i);
                        rfvlist.add(new FieldValue(colName, rs.getString(colName)));
                    }

                    //save each rowfieldvalues
                    rowFieldValuesResultList.add(rfvlist);

                } while (rs.next());
                log.info("Operation is ending...All rows scanned");
            }

            return rowFieldValuesResultList.isEmpty() ? Optional.empty() : Optional.of(rowFieldValuesResultList);
        }
        catch (Throwable ex) {
            throw new DaoException("getRowFieldValueListFromResultSet", ex);
        }
    }

    public Optional<List<RowFieldValues>> fillValues (String sqlCmd) throws DaoException
    {


        try (var con = DriverManager.getConnection(Global.URL, Global.USER, Global.PASSWORD);
             var stmt = con.createStatement()) {

            testDriver();

            return getRowFieldValueListFromResultSet(stmt.executeQuery(sqlCmd));

        } catch (Throwable ex) {
            log.info("fillValues-exception");
            throw new DaoException("fillValues-exception", ex);
        }
    }
}
