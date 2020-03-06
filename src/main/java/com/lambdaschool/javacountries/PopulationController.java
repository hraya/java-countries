package com.lambdaschool.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController
{
    @GetMapping(value = "/size/{people}",
                produces = {"application/json"})

    public ResponseEntity<?> getCountriesByPopulation(
            @PathVariable
                    int people)
    {
        ArrayList<Country> rtnctry = JavaCountriesApplication.ourCountryList.findCountries(e -> (int) (e.getPopulation()) >= people);
        rtnctry.sort((e1, e2) -> e1.getcName().compareToIgnoreCase(e2.getcName()));
        return new ResponseEntity<>(rtnctry, HttpStatus.OK);
    }

    @GetMapping(value = "/min",
                produces = {"application/json"})

    public ResponseEntity<?> getMinPop()
    {
        long minPop = 1000000000;
        Country currCountry = null;
        ArrayList<Country> tempPopList = JavaCountriesApplication.ourCountryList.countryList;
        for (Country c : tempPopList)
        {
            if (c.getPopulation() <= minPop)
            {
                minPop = c.getPopulation();
                currCountry = c;
            }

        }
        return new ResponseEntity<>(currCountry, HttpStatus.OK);
    }

    @GetMapping(value = "/max",
                produces = {"application/json"})

    public ResponseEntity<?> getMaxPop()
    {
        long maxPop = 0;
        Country curr_country = null;
        ArrayList<Country> tempPopList = JavaCountriesApplication.ourCountryList.countryList;
        for (Country c : tempPopList)
        {
            if (c.getPopulation() > maxPop)
            {
                maxPop = c.getPopulation();
                curr_country = c;
            }

        }
        return new ResponseEntity<>(curr_country, HttpStatus.OK);
    }
}
