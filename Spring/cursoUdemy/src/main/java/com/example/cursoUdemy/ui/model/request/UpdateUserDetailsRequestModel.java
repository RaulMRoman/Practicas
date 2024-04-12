package com.example.cursoUdemy.ui.model.request;

import jakarta.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {

    @jakarta.validation.constraints.NotNull(message = "First name cannot be null")
    @Size(min=2, message = "El nombre debe tener al menos 2 caracteres")
    private String firstName;

    @jakarta.validation.constraints.NotNull(message = "Last name cannot be null")
    private String lastName;

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
}
