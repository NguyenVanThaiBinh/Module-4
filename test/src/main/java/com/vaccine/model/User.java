package com.vaccine.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String userName;

    String CMND;

    String password;

    String phoneNumber;

    String email;

    //    get year only!
    int age;

    String gender;

//    Huyen
    String  district;

//    Xa~
    String commune;

    String healthyStatus;





}
