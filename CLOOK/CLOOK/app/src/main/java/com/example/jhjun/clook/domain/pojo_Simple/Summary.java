package com.example.jhjun.clook.domain.pojo_Simple;

/**
 * Created by jhjun on 2017-07-13.
 */

public class Summary
{
    private Tomorrow tomorrow;

    private String timeRelease;

    private DayAfterTomorrow dayAfterTomorrow;

    private Yesterday yesterday;

    private Today today;

    private Grid grid;

    public Tomorrow getTomorrow ()
    {
        return tomorrow;
    }

    public void setTomorrow (Tomorrow tomorrow)
    {
        this.tomorrow = tomorrow;
    }

    public String getTimeRelease ()
    {
        return timeRelease;
    }

    public void setTimeRelease (String timeRelease)
    {
        this.timeRelease = timeRelease;
    }

    public DayAfterTomorrow getDayAfterTomorrow ()
    {
        return dayAfterTomorrow;
    }

    public void setDayAfterTomorrow (DayAfterTomorrow dayAfterTomorrow)
    {
        this.dayAfterTomorrow = dayAfterTomorrow;
    }

    public Yesterday getYesterday ()
    {
        return yesterday;
    }

    public void setYesterday (Yesterday yesterday)
    {
        this.yesterday = yesterday;
    }

    public Today getToday ()
    {
        return today;
    }

    public void setToday (Today today)
    {
        this.today = today;
    }

    public Grid getGrid ()
    {
        return grid;
    }

    public void setGrid (Grid grid)
    {
        this.grid = grid;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [tomorrow = "+tomorrow+", timeRelease = "+timeRelease+", dayAfterTomorrow = "+dayAfterTomorrow+", yesterday = "+yesterday+", today = "+today+", grid = "+grid+"]";
    }
}