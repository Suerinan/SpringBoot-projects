package com.api.ericCrud.models;

import jakarta.persistence.*;

// THIS JAVA CLASS REPRESENTS THE TABLE USER CONSTRUCTION

@Entity
@Table(name = "user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column // (name = "first_name") | It is not necessary, but it is used to put a different name for the column
                                    // other than the variable name. It automatically camel_cases the name.
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
