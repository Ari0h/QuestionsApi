package com.testquiz.api.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "quizes")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "quiz_name", unique = true, nullable = false)
    private String quizName;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "quiz",
            cascade = CascadeType.ALL)
    private Set<Question> questions;
}
