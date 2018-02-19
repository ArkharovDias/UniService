package ru.itis.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "theme")
    private String theme;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private Date dateOfSending;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "test_question",
               joinColumns = @JoinColumn(name = "test_id"),
               inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private Set<Question> questions;


}
