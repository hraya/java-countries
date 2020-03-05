package com.lambdaschool.javacountries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController

@RequestMapping("/names")
public class CountryController
{
    @GetMapping(value = "/all",
                produces = {"application/json"})

    public ResponseEntity<?> getAllCountries()
    {
        JavaCountriesApplication.ourCountryList.countryList.sort((e1,e2) -> e1.getcName().compareToIgnoreCase(e2.getcName()));
        return new ResponseEntity<>(JavaCountriesApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    @GetMapping(value = "start/{letter}",
                produces = {"application/json"})

    public ResponseEntity<?> getCountryByCname(@PathVariable char letter)
    {
        ArrayList<Country> rtnCountry = JavaCountriesApplication.ourCountryList.findCountries(e -> e.getcName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnCountry.sort((e1,e2) -> e1.getcName()
        .compareToIgnoreCase(e2.getcName()));
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    @GetMapping(value = "/size/{number}",
                produces = {"application/json"})

    public ResponseEntity<?> getCountryByNameSize(@PathVariable int number)
    {
        ArrayList<Country> rtnNameSize = JavaCountriesApplication.ourCountryList.findCountries(e -> e.getcName().length() >=  number);
        rtnNameSize.sort((e1,e2) -> e1.getcName()
                .compareToIgnoreCase(e2.getcName()));
        return new ResponseEntity<>(rtnNameSize, HttpStatus.OK);
    }
}
