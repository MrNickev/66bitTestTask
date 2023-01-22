package com.example.test66bit.Repository;

import com.example.test66bit.Entities.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FootballerRepository extends JpaRepository<Footballer,Integer> {
    Footballer findFootballerById(Integer id);

    @Query(value = "SELECT * FROM footballer ORDER BY id offset :offset limit :limit", nativeQuery = true)
    List<Footballer> findAllPaginated(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
