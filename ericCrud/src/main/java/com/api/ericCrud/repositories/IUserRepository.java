package com.api.ericCrud.repositories;

import com.api.ericCrud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// THIS JAVA CLASS IS THE ONE WHO MAKES QUERIES TO A DATABASE
// From here it goes to UserService

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {
    // As this is a simple API we didn't have to create our own methods, we just had to use the JpaRepository
    // class methods
}
