package com.example.jhjun.clook.domain.pojo_Today;

/**
 * Created by jhjun on 2017-07-11.
 */

public class Data
{
    private Result result;

    private Common common;

    private Weather weather;

    public Result getResult ()
    {
        return result;
    }

    public void setResult (Result result)
    {
        this.result = result;
    }

    public Common getCommon ()
    {
        return common;
    }

    public void setCommon (Common common)
    {
        this.common = common;
    }

    public Weather getWeather ()
    {
        return weather;
    }

    public void setWeather (Weather weather)
    {
        this.weather = weather;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [result = "+result+", common = "+common+", weather = "+weather+"]"; // weather는 gson형태로 weather의 하위 값들이 모두 들어가 있음.
    }
}