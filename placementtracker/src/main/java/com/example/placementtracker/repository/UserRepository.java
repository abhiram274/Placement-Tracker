package com.example.placementtracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.placementtracker.entity.User;
/*
What this does?

Without writing SQL, Spring gives you:

save()

findById()

findAll()

delete()

 */


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

