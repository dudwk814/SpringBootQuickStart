package com.rupypaper.Chapter05.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Board {

    @Id @GeneratedValue
    private Long seq;
    private String title;
    private String writer;
    private String content;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createDate;
    private Long cnt;

}
