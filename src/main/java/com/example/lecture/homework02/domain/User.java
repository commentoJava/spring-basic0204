package com.example.lecture.homework02.domain;


import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Optional;

@Getter
@Setter
public class User {

    private String username;
    private String email;

    private int age;
    private String address;
    private String phoneNumber;

    private Gender gender;



    public void updateUser(String newEmail, String newAddress) {
        if (!Objects.equals(email, "") && email != null) {
            setEmail(newEmail);
        }

        if (!Objects.equals(newAddress, "") && newAddress != null) {
            setAddress(newAddress);
        }
    }



}
