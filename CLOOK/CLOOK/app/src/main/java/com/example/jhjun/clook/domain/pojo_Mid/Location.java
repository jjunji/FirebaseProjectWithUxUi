package com.example.jhjun.clook.domain.pojo_Mid;

/**
 * Created by jhjun on 2017-07-13.
 */

public class Location
{
    private String name;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+"]";
    }
}