package com.example.jhjun.clook.domain.pojo_Simple;

/**
 * Created by jhjun on 2017-07-13.
 */

public class Today
{
    private Sky sky;

    private Temperature temperature;

    public Sky getSky ()
    {
        return sky;
    }

    public void setSky (Sky sky)
    {
        this.sky = sky;
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
        return "ClassPojo [sky = "+sky+", temperature = "+temperature+"]";
    }
}
