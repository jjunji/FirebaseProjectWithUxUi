package com.example.jhjun.clook.domain.pojo_Simple;

/**
 * Created by jhjun on 2017-07-13.
 */

public class Yesterday
{
    private Sky sky;

    private Precipitation precipitation;

    private Temperature temperature;

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
        return "ClassPojo [sky = "+sky+", precipitation = "+precipitation+", temperature = "+temperature+"]";
    }
}
