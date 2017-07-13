package com.example.jhjun.clook.domain.pojo_Short;

/**
 * Created by jhjun on 2017-07-13.
 */

public class Fcstdaily
{
    private Temperature temperature;

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
        return "ClassPojo [temperature = "+temperature+"]";
    }
}