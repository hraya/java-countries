package com.lambdaschool.javacountries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class AgeController
{
    @GetMapping(value = "/age/{age}",
                produces = {"application/json"})
    public ResponseEntity<?> getMedianAges(@PathVariable int age)
    {
        ArrayList<Country> rtnctry = JavaCountriesApplication.ourCountryList.findCountries(e -> e.getMedianAge() >= age);
        return new ResponseEntity<>(rtnctry, HttpStatus.OK);
    }

    @GetMapping(value = "/min",
                produces = {"application/json"})
    public ResponseEntity<?> getMinMedianAge()
    {
        int minAge = 100;
        Country curr_country = null;
        ArrayList<Country> tempAgeList = JavaCountriesApplication.ourCountryList.countryList;
        for (Country c : tempAgeList)
        {
            if (c.getMedianAge() <= minAge)
            {
                minAge = c.getMedianAge();
                curr_country = c;
            }
        }
        return new ResponseEntity<>(curr_country, HttpStatus.OK);
    }

    @GetMapping(value = "/max",
                produces = {"application/json"})

    public ResponseEntity<?> getMaxAge()
    {
        int maxAge = 0;
        Country currCountry = null;
        ArrayList<Country> tempMaxAgeList = JavaCountriesApplication.ourCountryList.countryList;
        for (Country c : tempMaxAgeList)
        {
            if (c.getMedianAge() > maxAge)
            {
                maxAge = c.getMedianAge();
                currCountry = c;
            }

        }
        return new ResponseEntity<>(currCountry, HttpStatus.OK);
    }

}
