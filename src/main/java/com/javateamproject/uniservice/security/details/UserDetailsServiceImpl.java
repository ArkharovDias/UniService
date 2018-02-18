package com.javateamproject.uniservice.security.details;

import com.javateamproject.uniservice.models.User;
import com.javateamproject.uniservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 18.02.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Optional<User> existedUser = this.userRepository.findByLogin(login);

        if(!existedUser.isPresent()){
            throw new IllegalArgumentException("User not found by login <" + login + ">");
        }

        return new UserDetailsImpl(existedUser.get());

    }
}
