package com.example.test66bit.Services;

import com.example.test66bit.Entities.Club;
import com.example.test66bit.Entities.Country;
import com.example.test66bit.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public Country findByName(String name) {
        return countryRepository.findCountryByName(name);
    }

    public List<Country> getAll() {
        return countryRepository.findAll();
    }
}
