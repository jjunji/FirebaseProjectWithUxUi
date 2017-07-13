package com.example.jhjun.clook.domain.pojo_Short;

/**
 * Created by jhjun on 2017-07-13.
 */

public class Forecast3days
{
    private Fcst3hour fcst3hour;

    private String timeRelease;

    private Grid grid;

    private Fcstdaily fcstdaily;

    private Fcst6hour fcst6hour;

    public Fcst3hour getFcst3hour ()
    {
        return fcst3hour;
    }

    public void setFcst3hour (Fcst3hour fcst3hour)
    {
        this.fcst3hour = fcst3hour;
    }

    public String getTimeRelease ()
    {
        return timeRelease;
    }

    public void setTimeRelease (String timeRelease)
    {
        this.timeRelease = timeRelease;
    }

    public Grid getGrid ()
    {
        return grid;
    }

    public void setGrid (Grid grid)
    {
        this.grid = grid;
    }

    public Fcstdaily getFcstdaily ()
    {
        return fcstdaily;
    }

    public void setFcstdaily (Fcstdaily fcstdaily)
    {
        this.fcstdaily = fcstdaily;
    }

    public Fcst6hour getFcst6hour ()
    {
        return fcst6hour;
    }

    public void setFcst6hour (Fcst6hour fcst6hour)
    {
        this.fcst6hour = fcst6hour;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [fcst3hour = "+fcst3hour+", timeRelease = "+timeRelease+", grid = "+grid+", fcstdaily = "+fcstdaily+", fcst6hour = "+fcst6hour+"]";
    }
}