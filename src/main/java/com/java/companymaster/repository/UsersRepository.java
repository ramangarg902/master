package com.java.companymaster.repository;

import com.java.companymaster.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
}
