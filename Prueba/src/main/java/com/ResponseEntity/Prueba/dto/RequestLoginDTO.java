package com.ResponseEntity.Prueba.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = false)
public class RequestLoginDTO {

    private String email;
    private String contraseña;


    public RequestLoginDTO() {
    }

    public RequestLoginDTO(String email, String contraseña) {
        this.email = email;
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "RequestLoginDTO{" +
                "email='" + email + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
