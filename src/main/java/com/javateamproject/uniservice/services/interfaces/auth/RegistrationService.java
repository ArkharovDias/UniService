package com.javateamproject.uniservice.services.interfaces.auth;

import com.javateamproject.uniservice.forms.UserRegistrationForm;

/**
 * 18.02.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */
public interface RegistrationService {
    void register(UserRegistrationForm userForm);
}
