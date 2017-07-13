package com.example.jhjun.clook.domain.pojo_Mid;

/**
 * Created by jhjun on 2017-07-13.
 */

public class Weather
{
    private Forecast6days[] forecast6days;

    public Forecast6days[] getForecast6days ()
    {
        return forecast6days;
    }

    public void setForecast6days (Forecast6days[] forecast6days)
    {
        this.forecast6days = forecast6days;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [forecast6days = "+forecast6days+"]";
    }
}
