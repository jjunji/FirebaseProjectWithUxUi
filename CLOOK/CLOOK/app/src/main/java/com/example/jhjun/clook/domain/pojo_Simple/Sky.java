package com.example.jhjun.clook.domain.pojo_Simple;

/**
 * Created by jhjun on 2017-07-13.
 */

public class Sky
{
    private String name;

    private String code;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", code = "+code+"]";
    }
}
