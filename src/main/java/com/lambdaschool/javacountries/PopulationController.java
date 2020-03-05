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

    public ResponseEntity<?> getCountriesByPopulation(@PathVariable int people)
    {
        ArrayList<Country> rtnctry = JavaCountriesApplication.ourCountryList.findCountries(e -> (int) (e.getPopulation()) >= people);
        rtnctry.sort((e1,e2) -> e1.getcName()
                .compareToIgnoreCase(e2.getcName()));
        return new ResponseEntity<>(rtnctry, HttpStatus.OK);
    }
}
