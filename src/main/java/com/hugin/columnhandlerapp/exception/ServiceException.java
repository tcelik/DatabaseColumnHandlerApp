package com.hugin.columnhandlerapp.exception;

public class ServiceException extends RuntimeException{
    public ServiceException(String msg, Throwable cause)
    {
        super(msg, cause);
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
