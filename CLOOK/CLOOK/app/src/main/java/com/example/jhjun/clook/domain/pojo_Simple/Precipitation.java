package com.example.jhjun.clook.domain.pojo_Simple;

/**
 * Created by jhjun on 2017-07-13.
 */

public class Precipitation
{
    private String snow;

    private String rain;

    public String getSnow ()
    {
        return snow;
    }

    public void setSnow (String snow)
    {
        this.snow = snow;
    }

    public String getRain ()
    {
        return rain;
    }

    public void setRain (String rain)
    {
        this.rain = rain;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [snow = "+snow+", rain = "+rain+"]";
    }
}
