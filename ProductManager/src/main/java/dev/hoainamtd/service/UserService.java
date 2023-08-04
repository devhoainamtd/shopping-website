package dev.hoainamtd.service;

import dev.hoainamtd.dto.UserDTO;
import dev.hoainamtd.model.Role;
import dev.hoainamtd.model.UserEntity;

public interface UserService {
    UserDTO register(UserDTO registerDTO);
    UserEntity saveUser(UserEntity user);
    Role saveRole(Role role);
    void addToUser(String username, String name);
    boolean checkUsername(String username);
}
