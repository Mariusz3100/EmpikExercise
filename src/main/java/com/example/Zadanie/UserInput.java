package com.example.Zadanie;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserInput {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String login;

    private String name;

    private String type;

    private String avatar_url;
    private String created_at;
    private Float calculations;

    private int followers;
    private int public_repos;

}
