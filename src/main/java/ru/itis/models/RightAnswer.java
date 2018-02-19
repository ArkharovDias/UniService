package ru.itis.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "right_answer")
public class RightAnswer {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    private Answer answer;
}
