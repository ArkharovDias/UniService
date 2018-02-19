package ru.itis.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date dateOfCreation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "answer")
    private List<Answer> answers;

    @ManyToMany(mappedBy = "question")
    private Set<Test> tests;

    @OneToOne(mappedBy = "question")
    private RightAnswer rightAnswer;
}
