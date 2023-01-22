package com.example.test66bit.Entities;

import com.example.test66bit.DTO.FootballerDTO;
import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Footballer {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthdate")
    private Date birthdate;

    @ManyToOne
    private Country country;

    @ManyToOne
    private Club club;

    public Footballer() {
    }

    public Footballer(FootballerDTO footballerDTO) throws ParseException {
        id = footballerDTO.getId();
        name = footballerDTO.getName();
        secondName = footballerDTO.getSecondName();
        lastName = footballerDTO.getLastName();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        birthdate = format.parse(footballerDTO.getBirthdate());
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
