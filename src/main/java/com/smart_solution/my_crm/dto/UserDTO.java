package com.smart_solution.my_crm.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.UUID;

@Data
@NoArgsConstructor
public class UserDTO {
    private UUID id;

    @Email
    @UniqueElements(message = "Email should be unique.")
    @NotBlank(message = "Email cannot be empty.")
    private String email;

    @Length(min = 2, max = 25, message = "Firstname should be min 2 symbols and max 25 symbols.")
    @NotBlank(message = "Firstname cannot be empty.")
    private String firstname;

    @Length(min = 2, max = 50, message = "Lastname should be min 2 symbols and max 50 symbols.")
    @NotBlank(message = "Lastname cannot be empty.")
    private String lastname;

    @UniqueElements(message = "Phone number should be unique.")
    private String phone;

    @Length(min = 2, max = 70, message = "Country should be min 2 symbols and max 70 symbols.")
    @NotBlank(message = "Country cannot be empty.")
    private String country;

    @Length(min = 2, max = 120, message = "City should be min 2 symbols and max 120 symbols.")
    private String city;

    private int balance;

    private boolean isAdmin;

    private boolean isOnline;

    public UserDTO(String email, String firstname, String lastname, String country) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
    }

    public UserDTO(String email, String firstname, String lastname, String phone, String country, String city) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.country = country;
        this.city = city;
    }
}
