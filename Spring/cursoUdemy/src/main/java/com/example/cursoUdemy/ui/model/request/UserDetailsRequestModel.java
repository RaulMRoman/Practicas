package com.example.cursoUdemy.ui.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.jetbrains.annotations.NotNull;

public class UserDetailsRequestModel {
    @jakarta.validation.constraints.NotNull(message = "First name cannot be null")
    @Size(min=2, message = "El nombre debe tener al menos 2 caracteres")
    private String firstName;

    @jakarta.validation.constraints.NotNull(message = "Last name cannot be null")
    private String lastName;
    @jakarta.validation.constraints.NotNull(message = "Email name cannot be null")
    @Email
    private String email;
    @jakarta.validation.constraints.NotNull(message = "Password name cannot be null")
    @Size(min=8, max=16, message="Password debe tener al menos 8 caracteres, y 16 caracteres como máximo.")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
