package com.example.test66bit.Services;

import com.example.test66bit.Entities.Club;
import com.example.test66bit.Entities.Footballer;
import com.example.test66bit.Repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;

    public Club findByNameOrSaveNew(String name) {
        var club = clubRepository.findClubByName(name);
        if (club == null) {
            club = new Club();
            club.setName(name);
            save(club);
        }
        return club;

    }

    public void save(Club club) {
        clubRepository.save(club);
    }

    public List<Club> getAll() {
        return clubRepository.findAll();
    }
}
