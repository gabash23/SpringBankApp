package com.example.demo.currency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HolderRepository extends JpaRepository<Holder, Long> {

    @Query("SELECT h FROM Holder h WHERE h.username = ?1")
    Optional<Holder> findHolderByUsername(String username);

    @Query("SELECT h FROM Holder h WHERE h.id = ?1")
    Optional<Holder> findHolderById(Long id);

}
