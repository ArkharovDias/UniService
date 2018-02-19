package ru.itis.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "answer_description")
    private String answerDescription;

    @Column(name = "date")
    private Date dateOfCreation;

    @Column(name = "scoreValue")
    private Integer scoreValue;//количесво баллов за ответ

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToOne(mappedBy = "answer")
    private RightAnswer rightAnswer;
}
