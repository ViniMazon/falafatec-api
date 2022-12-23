package br.com.pifalafatec.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String raOrEmail;
    private String password;
}
