package com.example.jhjun.clook.domain.pojo_Short;

/**
 * Created by jhjun on 2017-07-13.
 */

public class Common
{
    private String alertYn;

    private String stormYn;

    public String getAlertYn ()
    {
        return alertYn;
    }

    public void setAlertYn (String alertYn)
    {
        this.alertYn = alertYn;
    }

    public String getStormYn ()
    {
        return stormYn;
    }

    public void setStormYn (String stormYn)
    {
        this.stormYn = stormYn;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [alertYn = "+alertYn+", stormYn = "+stormYn+"]";
    }
}
