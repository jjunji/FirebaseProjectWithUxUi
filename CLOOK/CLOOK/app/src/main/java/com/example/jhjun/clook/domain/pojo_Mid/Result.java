package com.example.jhjun.clook.domain.pojo_Mid;

/**
 * Created by jhjun on 2017-07-13.
 */

public class Result
{
    private String message;

    private String code;

    private String requestUrl;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    public String getRequestUrl ()
    {
        return requestUrl;
    }

    public void setRequestUrl (String requestUrl)
    {
        this.requestUrl = requestUrl;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", code = "+code+", requestUrl = "+requestUrl+"]";
    }
}
