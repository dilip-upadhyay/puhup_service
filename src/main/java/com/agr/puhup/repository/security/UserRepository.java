package com.agr.puhup.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agr.puhup.model.security.User;

/**
 * Created Dilip Upadhyay
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
