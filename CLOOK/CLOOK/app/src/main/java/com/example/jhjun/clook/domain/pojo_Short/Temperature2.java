package com.example.jhjun.clook.domain.pojo_Short;

/**
 * Created by jhjun on 2017-07-13.
 */

public class Temperature2
{
    private String tmin3day;

    private String tmax1day;

    private String tmin1day;

    private String tmax2day;

    private String tmin2day;

    private String tmax3day;

    public String getTmin3day ()
    {
        return tmin3day;
    }

    public void setTmin3day (String tmin3day)
    {
        this.tmin3day = tmin3day;
    }

    public String getTmax1day ()
    {
        return tmax1day;
    }

    public void setTmax1day (String tmax1day)
    {
        this.tmax1day = tmax1day;
    }

    public String getTmin1day ()
    {
        return tmin1day;
    }

    public void setTmin1day (String tmin1day)
    {
        this.tmin1day = tmin1day;
    }

    public String getTmax2day ()
    {
        return tmax2day;
    }

    public void setTmax2day (String tmax2day)
    {
        this.tmax2day = tmax2day;
    }

    public String getTmin2day ()
    {
        return tmin2day;
    }

    public void setTmin2day (String tmin2day)
    {
        this.tmin2day = tmin2day;
    }

    public String getTmax3day ()
    {
        return tmax3day;
    }

    public void setTmax3day (String tmax3day)
    {
        this.tmax3day = tmax3day;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [tmin3day = "+tmin3day+", tmax1day = "+tmax1day+", tmin1day = "+tmin1day+", tmax2day = "+tmax2day+", tmin2day = "+tmin2day+", tmax3day = "+tmax3day+"]";
    }
}
