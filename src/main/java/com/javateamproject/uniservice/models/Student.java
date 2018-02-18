package com.javateamproject.uniservice.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

/**
 * 18.02.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity(name = "Student")
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "profile_id")
    private Long id;

    @Column(name = "group_number")
    private String group;

    @Column(name = "course_number")
    private Integer course;

}
