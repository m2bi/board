package com.example.board;
import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
}
