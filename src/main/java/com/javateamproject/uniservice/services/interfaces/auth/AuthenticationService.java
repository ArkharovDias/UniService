package com.javateamproject.uniservice.services.interfaces.auth;

import com.javateamproject.uniservice.models.User;
import org.springframework.security.core.Authentication;
/**
 * 18.02.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */
public interface AuthenticationService {
    User getUserByAuthentication(Authentication authentication);
}
