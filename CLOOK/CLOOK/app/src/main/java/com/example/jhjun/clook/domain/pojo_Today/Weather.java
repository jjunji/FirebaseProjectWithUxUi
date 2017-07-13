package com.example.jhjun.clook.domain.pojo_Today;

/**
 * Created by jhjun on 2017-07-11.
 */

public class Weather
{
    private Hourly[] hourly;

    public Hourly[] getHourly ()
    {
        return hourly;
    }

    public void setHourly (Hourly[] hourly)
    {
        this.hourly = hourly;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [hourly = "+hourly+"]";
    }
}
