package com.example.jhjun.weatherparsingtest.domain;

/**
 * Created by jhjun on 2017-07-11.
 */

public class Temperature
{
    private String tmax;

    private String tc;

    private String tmin;

    public String getTmax ()
    {
        return tmax;
    }

    public void setTmax (String tmax)
    {
        this.tmax = tmax;
    }

    public String getTc ()
    {
        return tc;
    }

    public void setTc (String tc)
    {
        this.tc = tc;
    }

    public String getTmin ()
    {
        return tmin;
    }

    public void setTmin (String tmin)
    {
        this.tmin = tmin;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [tmax = "+tmax+", tc = "+tc+", tmin = "+tmin+"]";
    }
}
