package com.example.jhjun.clook.domain.pojo_Short;

/**
 * Created by jhjun on 2017-07-13.
 */

public class Fcst3hour
{
    private Wind wind;

    private Humidity humidity;

    private Sky sky;

    private Precipitation precipitation;

    private Temperature temperature;

    public Wind getWind ()
    {
        return wind;
    }

    public void setWind (Wind wind)
    {
        this.wind = wind;
    }

    public Humidity getHumidity ()
    {
        return humidity;
    }

    public void setHumidity (Humidity humidity)
    {
        this.humidity = humidity;
    }

    public Sky getSky ()
    {
        return sky;
    }

    public void setSky (Sky sky)
    {
        this.sky = sky;
    }

    public Precipitation getPrecipitation ()
    {
        return precipitation;
    }

    public void setPrecipitation (Precipitation precipitation)
    {
        this.precipitation = precipitation;
    }

    public Temperature getTemperature ()
    {
        return temperature;
    }

    public void setTemperature (Temperature temperature)
    {
        this.temperature = temperature;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [wind = "+wind+", humidity = "+humidity+", sky = "+sky+", precipitation = "+precipitation+", temperature = "+temperature+"]";
    }
}