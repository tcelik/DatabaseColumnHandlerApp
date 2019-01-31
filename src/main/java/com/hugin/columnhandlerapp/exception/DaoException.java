package com.hugin.columnhandlerapp.exception;

public class DaoException extends RuntimeException {
    public DaoException(String msg, Throwable cause)
    {
        super(msg, cause);
    }

    @Override
    public String toString()
    {
        return super.getMessage();
    }
}
