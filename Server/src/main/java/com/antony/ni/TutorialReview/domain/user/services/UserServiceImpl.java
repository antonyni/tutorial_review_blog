package com.antony.ni.TutorialReview.domain.user.services;

import com.antony.ni.TutorialReview.domain.user.exceptions.UserCreationException;
import com.antony.ni.TutorialReview.domain.user.exceptions.UserNotFoundException;
import com.antony.ni.TutorialReview.domain.user.models.User;
import com.antony.ni.TutorialReview.domain.user.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo){
        this.userRepo=userRepo;
    };
    @Override
    public User create(User user) throws UserCreationException {
        if (userRepo.findUserByEmail(user.getEmail()).isPresent())
            throw new UserCreationException("User with email: " + user.getEmail() + " already exists");
        if (userRepo.findUserByUsername(user.getUsername()).isPresent())
            throw new UserCreationException("User with username: " + user.getUsername() + " already exists");

        return userRepo.save(user);

    }

    @Override
    public User getById(UUID id) throws UserNotFoundException {
        Optional<User> userOptional = userRepo.findUserById(id);
        if(userOptional.isEmpty())
            throw new UserNotFoundException("User with id: " + id + " not found");
        return userOptional.get();
    }

    @Override
    public User getByEmail(String email) throws UserNotFoundException {
        Optional<User> userOptional = userRepo.findUserByEmail(email);
        if(userOptional.isEmpty())
            throw new UserNotFoundException("User with email: " + email + " not found");
        return userOptional.get();
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User update(UUID id, User userDetails) throws UserNotFoundException {
        User user = getById(id);
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setUsername(userDetails.getUsername());
        return userRepo.save(user);

    }

    @Override
    public void delete(UUID id) throws UserNotFoundException {
        User user = getById(id);
        userRepo.delete(user);

    }
}
