package com.api.ericCrud.services;

import com.api.ericCrud.models.UserModel;
import com.api.ericCrud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

// THIS JAVA CLASS HAS QUERY DEFINED METHODS AND SENDS THEM TO THE DB MANAGER (IUserRepository)
// From here it goes to IUserRepository

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    // CREATE METHODS
    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    // READ METHODS
    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }
    public Optional<UserModel> getUserById(long id) {
        return userRepository.findById(id);
    }

    // UPDATE METHODS
    public UserModel updateUserById(UserModel request, long id) {
        if(userRepository.findById(id).isPresent()) {
            UserModel user = userRepository.findById(id).get();
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setEmail(request.getEmail());
            userRepository.save(user);
            return user;
        }
        return null;
    }

    // DELETE METHODS
    public boolean deleteUserById(long id) {
        try{
            if(userRepository.findById(id).isPresent()) {
                userRepository.deleteById(id);
                return true;
            }
            return false;
        }catch (Exception e) {
            return false;
        }
    }
}
