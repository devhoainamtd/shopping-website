package dev.hoainamtd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String fullName;

    private String username;

    private String password;

    private String phoneNumber;

    private LocalDate dateOfBirth;

    private String sex;

}
