package com.example.jhjun.clook.domain.pojo_Simple;

/**
 * Created by jhjun on 2017-07-13.
 */

public class Temperature
{
    private String tmax;

    private String tmin;

    public String getTmax ()
    {
        return tmax;
    }

    public void setTmax (String tmax)
    {
        this.tmax = tmax;
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
        return "ClassPojo [tmax = "+tmax+", tmin = "+tmin+"]";
    }
}