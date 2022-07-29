package com.alkemy.projectDisney.projectDisney.auth.service;

import com.alkemy.projectDisney.projectDisney.auth.dto.UserDTO;
import com.alkemy.projectDisney.projectDisney.auth.entity.UserEntity;
import com.alkemy.projectDisney.projectDisney.auth.repository.UserRepository;
import com.alkemy.projectDisney.projectDisney.services.impl.SendMailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SendMailServiceImpl sendMailServiceImpl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByUsername(username);
        //if (userEntity == null)
        if (username == null) {
            throw new UsernameNotFoundException("Username or password not found.");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }

    public boolean save(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        userEntity = this.userRepository.save(userEntity);
        if (userEntity != null) {
            sendMailServiceImpl.sendWelcomeEmailTo(userEntity.getUsername());
        }
        return userEntity != null;

    }
}
