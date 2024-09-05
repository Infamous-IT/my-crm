package com.my_crm.repo;

import com.my_crm.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByCountry(String country);
    Optional<User> findUserByCity(String city);
}
