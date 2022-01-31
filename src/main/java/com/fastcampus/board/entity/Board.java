package com.fastcampus.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BOARD")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column(name = "SEQ", nullable = false, length = 5)
    private int seq;

    @Column(name = "TITLE", nullable = false, length = 200)
    private String title;

    @Column(name = "WRITER", nullable = false, length = 20)
    private String writer;

    @Column(name = "CONTENT", nullable = false, length = 2000)
    private String content;

    @CreationTimestamp
    @Column(name = "REG_DATE", nullable = false, length = 20)
    private Date regDate;

    @Column(name="CNT",nullable = true, length = 5)
    @ColumnDefault("0")
    private int cnt;


}
