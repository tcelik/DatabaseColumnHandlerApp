package com.hugin.columnhandlerapp.dao;

import com.hugin.columnhandlerapp.entity.FieldValue;
import com.hugin.columnhandlerapp.entity.RowFieldValues;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum DBClientDao {
    INSTANCE;

    //Properties config.
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "csd19933";

    //testing Driver
    public void testDriver() throws ClassNotFoundException
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Driver düzgün yüklenemedi");
            throw e; //yukarıya fırlat.
        }
    }

    //dummy data test
    public boolean insert() throws SQLException
    {
        var sqlCmd = "insert into terminalList (TerminalId, MerchantCode, FiscalId, DefaultBank) values (?, ?, ?, ?)";

        try (var con = DriverManager.getConnection(URL, USER, PASSWORD);
             var stmt = con.prepareStatement(sqlCmd)) {

            stmt.setInt(1, 0);
            stmt.setString(2, "Merchant10");
            stmt.setString(3, "Id0");
            stmt.setString(4, "Akbank");

            return stmt.executeUpdate() > 0;
        }
        catch (Throwable ex) {
            throw ex;
        }
    }

    public List<RowFieldValues> fillValues (String strSelect) throws SQLException
    {
        //result list
        List<RowFieldValues> result = new ArrayList<>();

        //RowFiledValues list
        RowFieldValues rfvl = new RowFieldValues();

        //Colon names for dynamic table.
        List<String> colNamesList = new ArrayList<>();

        //Connection & operation
        try (var con = DriverManager.getConnection(URL, USER, PASSWORD);
             var stmt = con.createStatement()) {

            //get the result
            ResultSet rs = stmt.executeQuery(strSelect);

            //metadata
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount(); //how many column

            //get the col name from metadata info and add the list
            for (int j = 1; j <= columnsNumber; j++) {
                String colName = rsmd.getColumnName(j);
                colNamesList.add(colName);
            }

            //each rs
            while (rs.next()) {

                rfvl.getFieldValues().clear();

                //get the col name from metadata info and add the list
                for (int j = 1; j <= columnsNumber; j++) {
                    String colName = rsmd.getColumnName(j);
                    rfvl.add(new FieldValue(colName, rs.getString(colName)));
                }

                //each rfvl add the array list
                result.add(rfvl);
            }

            System.out.println("Hiç bir satır bulunamadı");

            //return result
            return result;

        }
        catch (Exception ex) {
            throw ex;
        }

    }
}
