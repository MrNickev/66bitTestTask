package com.example.test66bit.DTO;

import com.example.test66bit.Entities.Club;
import com.example.test66bit.Entities.Country;
import com.example.test66bit.Entities.Footballer;
import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FootballerDTO {
    private Integer id;
    private String name;
    private String secondName;
    private String lastName;
    private String birthdate;
    private String country;
    private String club;
    private String gender;

    public FootballerDTO() {
    }

    public FootballerDTO(Footballer footballer) {
        id = footballer.getId();
        name = footballer.getName();
        secondName = footballer.getSecondName();
        lastName = footballer.getLastName();
        var format = new SimpleDateFormat("yyyy-MM-dd");
        birthdate = format.format(footballer.getBirthdate());
        country = footballer.getCountry().getName();
        club = footballer.getClub().getName();
        gender = footballer.getGender().toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
