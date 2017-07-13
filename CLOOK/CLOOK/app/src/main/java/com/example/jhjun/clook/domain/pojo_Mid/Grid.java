package com.example.jhjun.clook.domain.pojo_Mid;

/**
 * Created by jhjun on 2017-07-13.
 */

public class Grid
{
    private String village;

    private String county;

    private String city;

    public String getVillage ()
    {
        return village;
    }

    public void setVillage (String village)
    {
        this.village = village;
    }

    public String getCounty ()
    {
        return county;
    }

    public void setCounty (String county)
    {
        this.county = county;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [village = "+village+", county = "+county+", city = "+city+"]";
    }
}
