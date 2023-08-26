package com.antony.ni.TutorialReview.domain.user.services;

import com.antony.ni.TutorialReview.domain.user.exceptions.UserCreationException;
import com.antony.ni.TutorialReview.domain.user.exceptions.UserNotFoundException;
import com.antony.ni.TutorialReview.domain.user.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User create(User user) throws UserCreationException;

    User getById(UUID id) throws UserNotFoundException;

    User getByEmail(String email) throws UserNotFoundException;

    List<User> getAll();

    User update(UUID id, User user) throws UserNotFoundException;

    void delete(UUID id) throws UserNotFoundException;
}
