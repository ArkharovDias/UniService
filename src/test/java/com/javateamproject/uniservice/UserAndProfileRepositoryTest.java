package com.javateamproject.uniservice;

import com.javateamproject.uniservice.application.Application;
import com.javateamproject.uniservice.models.Profile;
import com.javateamproject.uniservice.models.User;
import com.javateamproject.uniservice.repositories.ProfileRepository;
import com.javateamproject.uniservice.repositories.UserRepository;
import com.javateamproject.uniservice.security.states.UserState;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 18.02.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserAndProfileRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    private User user;
    private Profile profile;

    @Before
    public void init(){

        this.user = User.builder()
                        .login("test12")
                        .password("gsdgfsdgfs")
                        .state(UserState.CONFIRMED)
                        .build();

        this.userRepository.save(user);

        this.profile = Profile.builder()
                              .name("test23")
                              .surname("teeeest2")
                              .user(this.user)
                              .build();


        this.profileRepository.save(profile);
    }

    @Test
    public void shouldSaveUserAndLinkToProfile(){
        Assertions.assertThat(profile.getUser()).isNotNull();
    }

    @Test
    public void shouldShowUserIdAndCheckRole(){
       Assertions.assertThat(this.user.getRoles()).isNotNull();
       Assertions.assertThat(this.profile.getUser().getId()).isGreaterThan(0L);
    }

    @After
    public void destroy(){
        this.profileRepository.delete(this.profile);
        this.userRepository.delete(this.user);
    }

}
