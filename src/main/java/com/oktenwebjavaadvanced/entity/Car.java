package com.oktenwebjavaadvanced.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Car {


    private int id;
    private String model;
    private String color;
    private int volume;
    private String nameDriver;

}
