package com.example.jhjun.clook.domain.pojo_Simple;

/**
 * Created by jhjun on 2017-07-13.
 */

public class Weather
{
    private Summary[] summary;

    public Summary[] getSummary ()
    {
        return summary;
    }

    public void setSummary (Summary[] summary)
    {
        this.summary = summary;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [summary = "+summary+"]";
    }
}
