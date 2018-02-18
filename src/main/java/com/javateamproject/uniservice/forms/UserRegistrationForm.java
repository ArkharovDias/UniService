package com.javateamproject.uniservice.forms;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.ToString;

/**
 * 18.02.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class UserRegistrationForm {

    private String login;
    private String password;
    private String passwordRepeat;
    private String role;
    private String name;
    private String surname;
    private String faculty;
    private String group;
    private Integer course;
    private String appointment;
    private String education;

}
