package com.example.jhjun.clook.domain.pojo_Today;

/**
 * Created by jhjun on 2017-07-11.
 */

public class Wind
{
    private String wspd;

    private String wdir;

    public String getWspd ()
    {
        return wspd;
    }

    public void setWspd (String wspd)
    {
        this.wspd = wspd;
    }

    public String getWdir ()
    {
        return wdir;
    }

    public void setWdir (String wdir)
    {
        this.wdir = wdir;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [wspd = "+wspd+", wdir = "+wdir+"]";
    }
}
