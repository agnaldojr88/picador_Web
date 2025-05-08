package com.agnjr.Web.repository;

import com.agnjr.Web.dto.UserDTO;
import com.agnjr.Web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username,String email);

    @Query("SELECT new com.agnjr.Web.dto.UserDTO(u.id, u.name, u.lastName, u.email, u.role) FROM User u")
    List<UserDTO> getAll();

}