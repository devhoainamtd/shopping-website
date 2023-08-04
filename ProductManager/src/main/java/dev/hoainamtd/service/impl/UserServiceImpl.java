package dev.hoainamtd.service.impl;

import dev.hoainamtd.dto.UserDTO;
import dev.hoainamtd.model.Role;
import dev.hoainamtd.model.UserEntity;
import dev.hoainamtd.repository.RoleRepository;
import dev.hoainamtd.repository.UserRepository;
import dev.hoainamtd.service.UserService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean checkUsername(String username) {
        if (!userRepository.existsByUsername(username)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserDTO register(UserDTO userDTO) {
            UserEntity user = mapToEntity(userDTO);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Role role = roleRepository.findByName("USER");
            user.setRoles(Collections.singletonList(role));
            userRepository.save(user);
        return userDTO;
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(user.getPassword());
            user.setRoles(new ArrayList<>());
            userRepository.save(user);
        } else {
            log.error("Username already exists");
        }
        return user;
    }

    @Override
    public Role saveRole(Role role) {
        return
        roleRepository.save(role);
    }

    @Override
    public void addToUser(String username, String name) {
        UserEntity user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(name);
        user.getRoles().add(role);
    }

    private UserEntity mapToEntity(UserDTO userDTO) {
        UserEntity user = new UserEntity();

        user.setId(null);
        user.setFullName(userDTO.getFullName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setSex(userDTO.getSex());

        return user;
    }
}
