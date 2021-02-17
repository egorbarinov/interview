package com.egorbarinov.demorepository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer age;
//    @Enumerated(EnumType.STRING) // Error java.lang.IllegalArgumentException: No enum constant com.egorbarinov.demorepository.entity.Gender.female
//    @Column
//    private Gender gender;


}
