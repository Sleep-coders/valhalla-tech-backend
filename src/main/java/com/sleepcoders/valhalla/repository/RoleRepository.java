package com.sleepcoders.valhalla.repository;

import java.util.Optional;

import com.sleepcoders.valhalla.models.users.ERole;
import com.sleepcoders.valhalla.models.users.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}