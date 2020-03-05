package com.lambdaschool.javacountries;

public class Country
{
    private String cName;
    private long population;
    private long landMass;
    private int medianAge;

    public Country(String cName, long population, long landMass, int medianAge)
    {
        this.cName = cName;
        this.population = population;
        this.landMass = landMass;
        this.medianAge = medianAge;
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
        return "Country{" + "cName='" + cName + '\'' + ", population=" + population + ", landMass=" + landMass + ", medianAge=" + medianAge + '}';
    }
}
