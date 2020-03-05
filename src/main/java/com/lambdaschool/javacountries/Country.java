package com.lambdaschool.javacountries;

import java.util.concurrent.atomic.AtomicLong;

public class Country
{
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String cName;
    private long population;
    private long landMass;
    private int medianAge;

    public Country(String cName, long population, long landMass, int medianAge)
    {
        this.id = counter.incrementAndGet();
        this.cName = cName;
        this.population = population;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }

    public Country(Country toClone)
    {
        this.cName = toClone.getcName();
        this.population = toClone.getPopulation();
        this.landMass = toClone.getLandMass();
        this.medianAge = toClone.getMedianAge();
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getcName()
    {
        return cName;
    }

    public void setcName(String cName)
    {
        this.cName = cName;
    }

    public long getPopulation()
    {
        return population;
    }

    public void setPopulation(long population)
    {
        this.population = population;
    }

    public long getLandMass()
    {
        return landMass;
    }

    public void setLandMass(long landMass)
    {
        this.landMass = landMass;
    }

    public int getMedianAge()
    {
        return medianAge;
    }

    public void setMedianAge(int medianAge)
    {
        this.medianAge = medianAge;
    }

    @Override
    public String toString()
    {
        return "Country{" + "id=" + id + ", cName='" + cName + '\'' + ", population=" + population + ", landMass=" + landMass + ", medianAge=" + medianAge + '}';
    }
}
