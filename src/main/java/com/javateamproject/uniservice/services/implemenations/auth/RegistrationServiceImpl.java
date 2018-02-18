package com.javateamproject.uniservice.services.implemenations.auth;

import com.javateamproject.uniservice.models.*;
import com.javateamproject.uniservice.repositories.*;
import com.javateamproject.uniservice.security.role.Role;
import com.javateamproject.uniservice.security.states.UserState;
import lombok.AllArgsConstructor;

import com.javateamproject.uniservice.forms.UserRegistrationForm;
import com.javateamproject.uniservice.services.interfaces.auth.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 18.02.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RegistrationServiceImpl implements RegistrationService{

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final RoleTypeRepository roleTypeRepository;
    private final StudentRepository studentRepository;
    private final LecturerRepository lecturerRepository;
    private final FacultyRepository facultyRepository;
    private final CooperatorRepository cooperatorRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(UserRegistrationForm userForm) {

        User newUser = User.builder()
                           .login(userForm.getLogin())
                           .password(this.passwordEncoder.encode(userForm.getPassword()))
                           .state(UserState.NOT_CONFIRMED)
                           .build();

        Profile profile = Profile.builder()
                                 .name(userForm.getName())
                                 .surname(userForm.getSurname())
                                 .build();

        RoleType role;
        Faculty faculty;
        Student student;
        Lecturer lecturer;
        Cooperator cooperator;

        this.userRepository.save(newUser);
        profile.setUser(newUser);
        this.profileRepository.save(profile);

        List<User> users = new ArrayList<>();
        users.add(newUser);

        List<Profile> profiles = new ArrayList<>();
        profiles.add(profile);

        switch(userForm.getRole()){

            case "STUDENT":

                role = RoleType.builder()
                               .role(Role.STUDENT)
                               .users(users)
                               .build();

                faculty = Faculty.builder()
                                 .title(userForm.getFaculty())
                                 .profiles(profiles)
                                 .build();

                student = Student.builder()
                                 .id(profile.getId())
                                 .group(userForm.getGroup())
                                 .course(userForm.getCourse())
                                 .build();

                this.roleTypeRepository.save(role);
                this.facultyRepository.save(faculty);
                this.studentRepository.save(student);

                break;

            case "LECTURER":

                role = RoleType.builder()
                               .role(Role.LECTURER)
                               .users(users)
                               .build();

                faculty = Faculty.builder()
                                 .title(userForm.getFaculty())
                                 .profiles(profiles)
                                 .build();

                lecturer = Lecturer.builder()
                                   .id(profile.getId())
                                   .appointment(userForm.getAppointment())
                                   .education(userForm.getEducation())
                                   .build();

                this.roleTypeRepository.save(role);
                this.facultyRepository.save(faculty);
                this.lecturerRepository.save(lecturer);

                break;

            case "COOPERATOR":

                role = RoleType.builder()
                               .role(Role.COOPERATOR)
                               .users(users)
                               .build();

                cooperator = Cooperator.builder()
                                       .id(profile.getId())
                                       .appointment(userForm.getAppointment())
                                       .build();

                this.roleTypeRepository.save(role);
                this.cooperatorRepository.save(cooperator);

                break;

        }

    }
}
