package dev.hoainamtd.controller;

import dev.hoainamtd.dto.UserDTO;
import dev.hoainamtd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("")
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterAccount() {
        return "register";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register (@RequestBody UserDTO userDTO) {
        if (userService.checkUsername(userDTO.getUsername())) {
            userService.register(userDTO);
            return ResponseEntity.ok("");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        }
    }
}
