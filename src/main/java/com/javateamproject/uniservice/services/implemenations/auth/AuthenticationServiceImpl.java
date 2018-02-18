package com.javateamproject.uniservice.services.implemenations.auth;

import com.javateamproject.uniservice.models.User;
import com.javateamproject.uniservice.repositories.UserRepository;
import com.javateamproject.uniservice.security.details.UserDetailsImpl;
import com.javateamproject.uniservice.services.interfaces.auth.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * 18.02.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByAuthentication(Authentication authentication) {

        UserDetailsImpl currentUserDetails = (UserDetailsImpl) authentication.getPrincipal();
        User currentUserModel = currentUserDetails.getUser();
        Long currentUserId = currentUserModel.getId();
        return this.userRepository.findOne(currentUserId);

    }

}
