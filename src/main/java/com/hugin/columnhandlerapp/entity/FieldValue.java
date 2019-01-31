package com.hugin.columnhandlerapp.entity;

public class FieldValue {
    private String m_columnName;
    private String m_columnValue;

    public FieldValue(String columnName, String columnValue)
    {
        m_columnName = columnName;
        m_columnValue = columnValue;
    }

    public String getColumnName()
    {
        return m_columnName;
    }

    public void setColumnName(String columnName)
    {
        m_columnName = columnName;
    }

    public String getColumnValue()
    {
        return m_columnValue;
    }

    public void setColumnValue(String columnValue)
    {
        m_columnValue = columnValue;
    }

    @Override
    public String toString()
    {
        return "FieldValue{" +
                "columnName='" + m_columnName + '\'' +
                ", columnValue='" + m_columnValue + '\'' +
                '}';
    }
}
