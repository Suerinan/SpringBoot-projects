package com.api.ericCrud.controllers;

import com.api.ericCrud.models.UserModel;
import com.api.ericCrud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

// IN THIS JAVA CLASS WE RECEIVE HTTP REQUESTS
// EACH ONE OF THE MAPPINGS RECEIVED CORRESPOND TO A URL FROM OUR PROGRAM WHERE WE WILL SEND THE DESIRED INFORMATION.
// from here it goes to UserService

@RestController
@RequestMapping(path = "/user") // Starting path position (e.g.: //localhost:3306/user)
public class UserController {

    @Autowired
    private UserService userService;

    // CREATE
    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    // READ
    @GetMapping
    public ArrayList<UserModel> getUsers() {
        return userService.getUsers();
    }
    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") long id) { //
        return userService.getUserById(id);
    }

    // UPDATE
    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable("id") long id) { //
        return this.userService.updateUserById(request, id);
    }

    // DELETE
    @DeleteMapping(path = "/{id}")
    public String deleteUserById(@PathVariable("id") long id) {
        boolean ok = this.userService.deleteUserById(id);

        if (ok){
            return "User with id: " + id + " deleted";
        }else {
            return "User with id: " + id + " could not be deleted";
        }
    }
}
