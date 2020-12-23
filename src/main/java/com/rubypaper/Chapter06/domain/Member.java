package com.rubypaper.Chapter06.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@ToString
@Entity
public class Member {

    @Id
    private String id;
    private String password;
    private String name;
    private String role;
}
