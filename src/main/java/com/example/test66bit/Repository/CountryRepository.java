package com.example.test66bit.Repository;

import com.example.test66bit.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Integer> {
    Country findCountryByName(String name);
}
