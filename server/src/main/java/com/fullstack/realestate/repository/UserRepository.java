package com.fullstack.realestate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fullstack.realestate.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
