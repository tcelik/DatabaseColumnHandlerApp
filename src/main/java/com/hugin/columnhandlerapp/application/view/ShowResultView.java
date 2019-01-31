package com.hugin.columnhandlerapp.application.view;

import com.hugin.columnhandlerapp.entity.FieldValue;
import com.hugin.columnhandlerapp.entity.RowFieldValues;

import javax.print.DocFlavor;
import java.util.List;

public class ShowResultView {
    //Modeli al
    private List<RowFieldValues> m_rowFieldValuesList;

    public ShowResultView(List<RowFieldValues> rfvlist)
    {
        m_rowFieldValuesList = rfvlist;
    }

    public void view()
    {
        StringBuilder resultTag = new StringBuilder();

        for (RowFieldValues rfv : m_rowFieldValuesList) {
            if (resultTag.toString().isEmpty()) { //table yaparken boşsa column name için
                for (FieldValue fv : rfv.getFieldValues()) {
                    resultTag.append(fv.getColumnName() + " ");
                }
                resultTag.append("\n--------------------------------\n");
            }
            resultTag.append(rfv.toString()+"\n");
        }

        System.out.println(resultTag.toString());
    }


}
