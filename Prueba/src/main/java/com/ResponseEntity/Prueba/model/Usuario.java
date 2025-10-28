package com.ResponseEntity.Prueba.model;

// No se ponen anotaciones por que no se va a manejar una base de datos
public class Usuario {
    private long id;
    private String username;
    private String email;
    private String contraseña;
    private static long contador = 0;


    public Usuario() {
    }

    public Usuario(String username, String email, String contraseña) {
        this.id = ++contador;
        this.username = username;
        this.email = email;
        this.contraseña = contraseña;
    }

    public Usuario(long id, String contraseña, String email, String username) {
        this.id = ++contador;
        this.contraseña = contraseña;
        this.email = email;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
