package com.my_crm.domain;

import com.my_crm.domain.enums.Category;
import com.my_crm.domain.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "firstname", length = 25, nullable = false)
    private String firstname;

    @Column(name = "lastname", length = 50, nullable = false)
    private String lastname;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "balance")
    private int balance;

    @Column(name = "is_admin")
    private boolean isAdmin = false;

    @Column(name = "is_online")
    private boolean isOnline;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @ElementCollection(targetClass = Category.class)
    @CollectionTable(name = "user_categories", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private List<Category> categories;

    public User(String email, String firstname, String lastname, String country, String password) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.password = password;
    }

    public User(String email, String firstname, String lastname, String phone, String country, String city, String password) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.password = password;
    }
}
