package com.example.jhjun.clook.domain.pojo_Short;

/**
 * Created by jhjun on 2017-07-13.
 */

public class Weather
{
    private Forecast3days[] forecast3days;

    public Forecast3days[] getForecast3days ()
    {
        return forecast3days;
    }

    public void setForecast3days (Forecast3days[] forecast3days)
    {
        this.forecast3days = forecast3days;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [forecast3days = "+forecast3days+"]";
    }
}
