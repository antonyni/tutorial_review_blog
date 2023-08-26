package com.antony.ni.TutorialReview.domain.user.repos;

import com.antony.ni.TutorialReview.domain.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
    Optional<User> findUserById(UUID id);

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByEmail(String email);

}
