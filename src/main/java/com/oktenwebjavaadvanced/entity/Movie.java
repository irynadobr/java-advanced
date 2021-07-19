package com.oktenwebjavaadvanced.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//@Table (name = "Movie_table")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100)
    @NotBlank
    @JsonProperty("title-of-movie")
    private String title;
    @Positive
    private int duration;
}
