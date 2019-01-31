package com.hugin.columnhandlerapp.entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RowFieldValues {
    //İçinde bir liste var FieldValue tutsun.
    private List<FieldValue> m_fieldValues;

    public RowFieldValues()
    {
        m_fieldValues = new ArrayList<>();
    }

    public boolean add(FieldValue fv)
    {
        m_fieldValues.add(fv);
        return true;
    }

    public List<FieldValue> getFieldValues()
    {
        return m_fieldValues;
    }

    public void setFieldValues(List<FieldValue> fieldValues)
    {
        m_fieldValues = fieldValues;
    }

}
