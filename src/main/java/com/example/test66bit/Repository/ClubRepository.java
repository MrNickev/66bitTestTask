package com.example.test66bit.Repository;

import com.example.test66bit.Entities.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club,Integer> {
    Club findClubByName(String name);
}
