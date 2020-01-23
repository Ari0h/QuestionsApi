package com.testquiz.api.model;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne (fetch=FetchType.EAGER,
            cascade=CascadeType.ALL)
    @JoinColumn (name="quiz_id")
    private Quiz quiz;

    @Column(name = "question_text", nullable = false)
    private String questionText;

    @Column(name = "filter_number")
    private Long filterNumber;

}
